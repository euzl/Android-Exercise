package com.euzl.appwidget

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RemoteViews
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import com.euzl.appwidget.databinding.ActivityAppWidgetConfigureBinding

class AppWidgetConfigure() : AppCompatActivity() {

    lateinit var binding: ActivityAppWidgetConfigureBinding
    var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // result := CANCELED
        // Back button 을 누르는 등 호스트가 위젯을 놓다가 취소했을 때
        setResult(RESULT_CANCELED)


        // set Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app_widget_configure)
        binding.activity = this

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
        binding.widgetPreview.background.alpha = progress

    }

    fun onConfirmClick(view: View) {
        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(this)

        // remote view를 통해 레이아웃 업데이트
        RemoteViews(packageName, R.layout.example_appwidget).also { views ->
            views.setTextViewText(R.id.textView, "투명도 ${binding.seekBar.progress*100/255}%")
            // TODO: 배경색 투명도 조절
            appWidgetManager.updateAppWidget(appWidgetId, views)

        }

        // app widget id 를 포함한 결과 반환
        val resultValue = Intent().apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        }
        setResult(Activity.RESULT_OK, resultValue)
        finish()
    }
}