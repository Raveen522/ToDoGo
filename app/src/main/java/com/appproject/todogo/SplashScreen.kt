package com.appproject.todogo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.ImageView

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        val introImages: ImageView = findViewById(R.id.intro_images)
        val imageArray:Array<Int> = arrayOf(R.drawable.computer_task,R.drawable.task_list,R.drawable.time,R.drawable.tasks,R.drawable.write_task,R.drawable.computer_task,R.drawable.time,R.drawable.tasks,R.drawable.logo)
        var image = 0
        val handler = Handler()
        Thread {
            while (true) {
                introImages.setImageResource(imageArray[image++ % imageArray.size])
                SystemClock.sleep(180)
            }
        }.start()
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()},2000)
    }
}