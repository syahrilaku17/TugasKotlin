package com.example.pertemuanandroid8.register

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pertemuanandroid8.R
import com.example.pertemuanandroid8.otherway.AfterLogin
import org.jetbrains.anko.*

class ActivityRegister : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RegisView().setContentView(this)
        var btn : Button = findViewById(R.id.btn_regis)
        var fulname : EditText = findViewById(R.id.et_fullname)
        var uname : EditText = findViewById(R.id.et_username_regis)
        var passwd : EditText = findViewById(R.id.et_password_regis)

        btn.setOnClickListener {
            val fullname = fulname.text.toString().trim()
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            hadleRegisiter(fullname, username, password)
        }
    }
    class RegisView : AnkoComponent<ActivityRegister> {
        override fun createView(ui: AnkoContext<ActivityRegister>)= with(ui) {
            verticalLayout {
                lparams{
                    width = matchParent
                    height = matchParent
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abuabu
                }
                verticalLayout {
                    lparams(width = matchParent, height = matchParent){
                        backgroundColor = Color.WHITE
                    }
                    textView{
                        hint = "REGISTER"
                        textSize  = 25f
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                        typeface = Typeface.create(Typeface.DEFAULT,Typeface.BOLD_ITALIC)
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                    editText {
                        id  = R.id.et_fullname
                        hint = "Fullname"
                        textSize = 20f
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                    editText {
                        id  = R.id.et_username_regis
                        hint = "Username"
                        textSize = 20f
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                    editText {
                        id  = R.id.et_password_regis
                        hint = "password"
                        textSize = 20f
                        inputType =  InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }.lparams(width = matchParent, height = wrapContent ){
                        margin = 15
                    }
                    button( "REGISTER"){
                        id = R.id.btn_regis
                    }.lparams(width = wrapContent, height =  wrapContent){
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                }
            }
        }
    }
    private fun hadleRegisiter(fullname : String, username : String, password : String){
        info { "Fullname : $fullname, \n Username : $username, \n Password : $password" }
        when{
            fullname.isEmpty() -> toast("Fullname Belum di isi")
            username.isEmpty() -> toast("Username Belum di isi")
            password.isEmpty() -> toast("Password Belum di isi")
            else -> alert(title = "Register", message = "Account baru di tambahkan") {
                negativeButton(buttonText = "OK"){
                    onBackPressed()
                    startActivity(intentFor<ActivityWelcome>("fullname" to fullname,"username" to username,"password" to password))
                }
                isCancelable = false
            }.show()
        }
    }
}