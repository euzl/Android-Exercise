package com.euzl.customdrawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import kotlin.math.log

data class Point(var x:Float, var y:Float, var color:Int, var isContinue:Boolean, var shape: Int)

private const val TAG = "Draw"
class Draw : View  {
    var list = arrayListOf<Point>()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) { }

    // 도형 설정 값
    val P_FREE = 4
    val P_CIRCLE = 5
    val P_SQUARE = 6

    var shape = P_FREE //init shape

    var paintColor = Color.RED

    // 페인트 도구
    var paint:Paint
    init{
        paint = Paint()
        paint.strokeWidth = 10F
        paint.color = paintColor
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw: ${list.size}")

        // 점들을 연결하자.
        list.forEachIndexed { index, point ->
            if (index > 0 && point.isContinue) {
                if (point.color != paint.color) paint.color = point.color
                paint.style = Paint.Style.STROKE // 도형 테두리만 칠하기

                // 도형에 따라 다르게 그리기
                when(point.shape) {
                    P_FREE -> canvas.drawLine(list[index-1].x, list[index-1].y, list[index].x, list[index].y, paint)
                    P_CIRCLE -> canvas.drawArc(list[index-1].x, list[index-1].y, list[index].x, list[index].y,
                        0F, 360F, true, paint)
                    P_SQUARE -> canvas.drawRect(list[index-1].x, list[index-1].y, list[index].x, list[index].y, paint)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(shape){
            P_FREE -> return drawFree(event)
            P_CIRCLE -> return drawPoly(event)
            P_SQUARE -> return drawPoly(event)
        }
        return true
    }

    private fun drawFree(event: MotionEvent?):Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                list.add(Point(event?.x, event?.y, paintColor, false, shape))
            }
            MotionEvent.ACTION_MOVE -> {
                list.add(Point(event?.x, event?.y, paintColor, true, shape))
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        invalidate()
        return true
    }

    private fun drawPoly(event: MotionEvent?):Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                list.add(Point(event?.x, event?.y, paintColor, false, shape))
            }
            MotionEvent.ACTION_MOVE -> {
            }
            MotionEvent.ACTION_UP -> {
                list.add(Point(event?.x, event?.y, paintColor, true, shape))
            }
        }

        invalidate()
        return true
    }

    fun clear() {
        list.clear()
        invalidate()
        Log.d(TAG, "clear: clear all")
        paintColor = Color.RED // set default color
    }

    fun eraseMode() {
        shape = P_FREE
        paintColor = Color.WHITE
        Log.d(TAG, "eraseMode: erase start")
    }

    fun changeColor(@ColorInt color: Int) {
        paintColor = color
    }

    fun changeShape(selectedShape: Int) {
        shape = selectedShape
    }
}