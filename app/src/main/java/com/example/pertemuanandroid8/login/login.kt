package com.example.pertemuanandroid8.login

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.pertemuanandroid8.R
import org.jetbrains.anko.*

class login : AppCompatActivity(), AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewLoginView().setContentView(this)
//         var btn : Button = findViewById(R.id.btn)
//         var uname : EditText = findViewById(R.id.et_username)
//         var pass : EditText = findViewById(R.id.et_password)
//
//        btn.setOnClickListener {
//            val username = uname.text.toString().trim()
//            val password = pass.text.toString().trim()
//        }

    }

    class NewLoginView : AnkoComponent<login> {
        override fun createView(ui: AnkoContext<login>)=with(ui) {
            verticalLayout {
                lparams{
                    width = matchParent
                    height = matchParent
                    background =  ColorDrawable(Color.parseColor("#1fb0c6"))
                }
                imageView{
                    setImageResource(R.drawable.logo)
                }.lparams(width = 200, height = 200){
                    margin = 15
                    gravity = Gravity.CENTER
                    topMargin = 100
                }
                textView {
                    text = "Email"
                    textColor = Color.WHITE
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                    topMargin = 100
                }
                editText {
                    id = R.id.et_username
                    hint = "Masukan Nama"
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText {
                    id = R.id.et_username
                    hint = "Masukan Password"
                    inputType =  InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                button (text = "LOGIN") {
                    id = R.id.btn
                    gravity = Gravity.CENTER
                    textSize = 20f
                    background =  ColorDrawable(Color.parseColor("#ffd800"))
                }.lparams(width = matchParent, height = 70){
                    margin = 15
                }
                textView {
                    text = " Forgot your Password?"
                    textColor = Color.YELLOW
                }.lparams{
                    gravity = Gravity.CENTER
                    topMargin = 100
            }
                textView {
                    text = " Not a Memeber? get Register Now in Firebase Now"

                    textColor = Color.WHITE
                }.lparams{
                    gravity = Gravity.CENTER
                    topMargin = 150
                }
            }
        }
    }
}