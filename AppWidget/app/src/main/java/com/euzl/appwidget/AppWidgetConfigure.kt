package com.euzl.appwidget

import android.Manifest
import android.app.Activity
import android.app.WallpaperManager
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RemoteViews
import android.widget.SeekBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.databinding.DataBindingUtil
import com.euzl.appwidget.databinding.ActivityAppWidgetConfigureBinding

class AppWidgetConfigure() : AppCompatActivity() {

    private lateinit var binding: ActivityAppWidgetConfigureBinding
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    lateinit var ivBackground: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // result := CANCELED
        // Back button 을 누르는 등 호스트가 위젯을 놓다가 취소했을 때
        setResult(RESULT_CANCELED)


        // set Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app_widget_configure)
        binding.activity = this

        // user wall paper (퍼미션 확인 후)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            binding.ivWallPaper.setImageDrawable(WallpaperManager.getInstance(applicationContext).drawable)
        }

        // background image for opacity
        ivBackground = findViewById<ImageView?>(R.id.ivWidgetBackground).apply {
            setColorFilter(R.color.white)
        }

        // intent로부터 Widget Id 얻기
        appWidgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            appWidgetId
        ) ?: appWidgetId

        // widget id 가 없이 오면 끝
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
        }
    }

    fun onSeekBarProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        binding.textView.text = "배경 투명도 조절 : ${progress*100/255}%"
        ivBackground.imageAlpha = binding.seekBar.progress
    }

    fun onConfirmClick(view: View) {
        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(this)

        // remote view를 통해 레이아웃 업데이트
        RemoteViews(packageName, R.layout.example_appwidget).apply {
            setTextViewText(R.id.textView, "투명도 ${binding.seekBar.progress*100/255}%")
            setInt(R.id.ivWidgetBackground, "setColorFilter", R.color.white)
            setInt(R.id.ivWidgetBackground, "setImageAlpha", binding.seekBar.progress)
            appWidgetManager.updateAppWidget(appWidgetId, this)
        }

        // app widget id 를 포함한 결과 반환
        val resultValue = Intent().apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        }
        setResult(Activity.RESULT_OK, resultValue)
        finish()
    }
}