package com.mc24laghouat.game

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View

class GameView(context: Context) : View(context) {

    private val paint = Paint()

    // اللاعب
    private var playerX = 300f
    private var playerY = 500f

    // الكرة
    private var ballX = 600f
    private var ballY = 500f
    private var ballVX = 0f
    private var ballVY = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // خلفية الملعب
        canvas.drawColor(Color.rgb(30, 120, 60))

        // رسم الكرة
        paint.color = Color.WHITE
        canvas.drawCircle(ballX, ballY, 25f, paint)

        // رسم اللاعب
        paint.color = Color.BLUE
        canvas.drawCircle(playerX, playerY, 40f, paint)

        // فيزياء بسيطة للكرة
        ballX += ballVX
        ballY += ballVY

        ballVX *= 0.98f
        ballVY *= 0.98f

        // اصطدام بسيط مع اللاعب
        val dx = ballX - playerX
        val dy = ballY - playerY
        val dist = Math.sqrt((dx * dx + dy * dy).toDouble())

        if (dist < 65) {
            ballVX = dx.toFloat() * 0.2f
            ballVY = dy.toFloat() * 0.2f
        }

        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        playerX = event.x
        playerY = event.y
        return true
    }
}
