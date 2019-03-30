package com.example.pertemuanandroid8.otherway

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.pertemuanandroid8.R
import org.jetbrains.anko.*

class AfterLogin : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AfterLoginView().setContentView(this)
        var tv_ : TextView = findViewById(R.id.tv_afterlogin)
        val data = intent.getStringExtra("kode")
        tv_.text = data
    }

    class AfterLoginView : AnkoComponent<AfterLogin> {
        override fun createView(ui: AnkoContext<AfterLogin>)=with(ui) {
            verticalLayout {
                lparams{
                    width = matchParent
                    height = matchParent
                    background =  ColorDrawable(Color.parseColor("#1fb0c6"))
                }
                textView{
                    text = "WELCOME !"
                    textSize = 40f
                    gravity = Gravity.CENTER
                }
                textView {
                    id = R.id.tv_afterlogin
                    textSize = 30f
                    gravity = Gravity.CENTER

                }
            }
        }
    }
}