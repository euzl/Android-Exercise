package com.euzl.edittext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.euzl.edittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSetText.setOnClickListener { startActivity(Intent(this, SetTextActivity::class.java)) }
        binding.buttonNotModify.setOnClickListener { startActivity(Intent(this, NotModifyTextActivity::class.java)) }
        binding.buttonTextChangeEvent.setOnClickListener { startActivity(Intent(this, TextChangeEventActivity::class.java)) }
    }
}