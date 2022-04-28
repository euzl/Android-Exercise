package com.euzl.appwidget

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()
    }

    /**
     * 권한 요청
     */
    private fun requestPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            var permissions = arrayOf( Manifest.permission.READ_EXTERNAL_STORAGE )
            ActivityCompat.requestPermissions(this, permissions, 100)
        }
    }
}