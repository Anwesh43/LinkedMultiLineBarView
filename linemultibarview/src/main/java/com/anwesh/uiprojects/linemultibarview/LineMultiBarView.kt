package com.anwesh.uiprojects.linemultibarview

/**
 * Created by anweshmishra on 14/10/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val nodes : Int = 5
val bars : Int = 5
val scGap : Float = 0.01f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#283593")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawBar(i : Int, xGap : Float, hGap : Float, sc : Float, paint : Paint) {
    val sci : Float = sc.divideScale(i, bars)
    save()
    translate(xGap * i,  hGap)
    drawRect(RectF(-hGap * sci, 0f, xGap, hGap * sci), paint)
    restore()
}

fun Canvas.drawLineMutliBar(i : Int, w : Float, h : Float, scale : Float, paint : Paint) {
    val xGap : Float = w / nodes
    val hGap : Float = h / nodes
    save()
    translate(0f, hGap * i)
    for (j in 0..(bars - 1)) {
        drawBar(j, xGap, hGap, scale.divideScale(1, 2), paint)
    }
    drawLine(0f, hGap, w * scale.divideScale(0, 2), hGap, paint)
    restore()
}

fun Canvas.drawLMBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawLineMutliBar(i, w, h, scale, paint)
}

class LineMultiBarView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}