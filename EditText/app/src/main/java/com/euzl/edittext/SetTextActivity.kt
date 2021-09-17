package com.euzl.edittext

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.euzl.edittext.databinding.ActivitySetTextBinding

class SetTextActivity : AppCompatActivity() {
    lateinit var binding: ActivitySetTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val input = binding.editTextInput.text.toString()
            if (!input.isEmpty()) {

                // 속성에 직접 대입 (X : Type Mismatch)
                // binding.editTextOutput.text = input

                // setter 사용 (O)
                binding.editTextOutput.setText(input)

                // Editable 형태로 바꾸기 (O)
                binding.editTextOutput2.text = Editable.Factory.getInstance().newEditable(input)
            }
        }
    }
}