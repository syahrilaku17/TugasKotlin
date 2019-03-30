package com.example.pertemuanandroid8.register


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pertemuanandroid8.R
import org.jetbrains.anko.*

class ActivityWelcome : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AfterLoginView().setContentView(this)
        var tv_ : TextView = findViewById(R.id.tv_afterlogin_fullname)
        val data = intent.getStringExtra("fullname")
        tv_.text = data
        var tv_1 : TextView = findViewById(R.id.tv_afterlogin_username)
        val data1 = intent.getStringExtra("username")
        tv_1.text = data1
        var tv_2 : TextView = findViewById(R.id.tv_afterlogin_password)
        val data2 = intent.getStringExtra("password")
        tv_2.text = data2
        var btn : Button = findViewById(R.id.btn_lanjutkan)
        btn.setOnClickListener {
            toast("Maaf halamn Belum tersedia")
        }
        }
    }

    class AfterLoginView : AnkoComponent<ActivityWelcome> {
        override fun createView(ui: AnkoContext<ActivityWelcome>)=with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    background = ColorDrawable(Color.parseColor("#1fb0c6"))
                }
                textView {
                    text = "Welcome New Member !"
                    textSize = 30f
                    gravity = Gravity.CENTER

                }
                verticalLayout {
                    lparams {
                        width = matchParent
                        height = matchParent
                        background = ColorDrawable(Color.parseColor("#0037ff"))
                        margin = 50
                        padding = 20
                    }
                    textView{
                        text = "Nama Lengkap Anda :"
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    editText {
                        id = R.id.tv_afterlogin_fullname
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    textView{
                        text = "Nama Akun Anda :"
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    editText {
                        id = R.id.tv_afterlogin_username
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    textView{
                        text = "Password Anda :"
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    editText{
                        id = R.id.tv_afterlogin_password
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                    button {
                        id = R.id.btn_lanjutkan
                        height = matchParent
                        width = wrapContent
                        text = "Lanjutkan"
                    }
                }
            }
        }
    }
