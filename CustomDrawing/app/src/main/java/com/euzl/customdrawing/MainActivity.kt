package com.euzl.customdrawing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.euzl.customdrawing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.paletteLayout.visibility = View.GONE
        binding.polyLayout.visibility = View.GONE

        setListener()
    }

    fun setListener() {
        var typeListener = TypeListener()
        binding.clearButton.setOnClickListener(typeListener)
        binding.eraserButton.setOnClickListener(typeListener)
        binding.paletteButton.setOnClickListener(typeListener)
        binding.polyButton.setOnClickListener(typeListener)

        var colorListener = ColorListener()
        binding.redButton.setOnClickListener(colorListener)
        binding.blackButton.setOnClickListener(colorListener)
        binding.blueButton.setOnClickListener(colorListener)

        var shapeListener = ShapeListener()
        binding.freeButton.setOnClickListener(shapeListener)
        binding.circleButton.setOnClickListener(shapeListener)
        binding.squareButton.setOnClickListener(shapeListener)
    }

    inner class TypeListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            binding.paletteLayout.visibility = View.GONE
            binding.polyLayout.visibility = View.GONE

            when(p0?.id) {
                R.id.clearButton -> binding.draw.clear()
                R.id.eraserButton -> binding.draw.eraseMode()
                R.id.paletteButton -> {
                    binding.paletteLayout.visibility = View.VISIBLE
                }
                R.id.polyButton -> {
                    binding.polyLayout.visibility = View.VISIBLE
                }
            }
        }
    }

    inner class ColorListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            when(p0?.id) {
                R.id.redButton -> binding.draw.changeColor(Color.RED)
                R.id.blackButton -> binding.draw.changeColor(Color.BLACK)
                R.id.blueButton -> binding.draw.changeColor(Color.BLUE)
            }
        }
    }

    inner class ShapeListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            binding.polyLayout.visibility = View.GONE

            when(p0?.id) {
                R.id.freeButton -> binding.draw.changeShape(binding.draw.P_FREE)
                R.id.circleButton -> binding.draw.changeShape(binding.draw.P_CIRCLE)
                R.id.squareButton -> binding.draw.changeShape(binding.draw.P_SQUARE)
            }
        }
    }
}