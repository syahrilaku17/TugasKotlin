package com.example.pertemuanandroid8.otherway

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pertemuanandroid8.R
import com.example.pertemuanandroid8.Register
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class Main2 : AppCompatActivity(), AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)
        var btn : Button = findViewById(R.id.btn)
        var uname : EditText = findViewById(R.id.et_username)
        var passwd : EditText = findViewById(R.id.et_password)
        var regis : TextView = findViewById(R.id.tv_ca)

        btn.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            handleLogin(username, password)
        }
        regis.setOnClickListener {
            toast("Pindah Ke halaman register")
            startActivity(intentFor<Regis2>())
        }
    }

//    membuat class yang mendesain layout
    class LoginView : AnkoComponent<Main2> {
    override fun createView(ui: AnkoContext<Main2>)= with(ui) {
        verticalLayout {
            lparams{
                width = matchParent
                height = matchParent
                padding = 30
                verticalGravity = Gravity.CENTER
                backgroundColor = R.color.abuabu
            }
            verticalLayout {
                lparams(width = matchParent, height = wrapContent){
                    backgroundColor = Color.WHITE
                    margin = 15
                    padding = 20
                }
                textView{
                    hint = "Login"
                    textSize  = 25f
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText {
                    id  = R.id.et_username
                    hint = "Username"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText {
                    id  = R.id.et_password
                    hint = "password"
                    textSize = 20f
                    inputType =  TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent ){
                    margin = 15
                }
                button( "LOGIN"){
                    id = R.id.btn
                }.lparams(width = wrapContent, height =  wrapContent){
                    margin = 15
                    gravity = Gravity.CENTER
                }
                textView{
                    id = R.id.tv_ca
                    text = "Create new Account?"
                    textSize = 15f
                    textColor = R.color.biru
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
            }
        }
    }
}
    private fun  handleLogin(username : String, password : String){
        info { "data Username : $username, data Password : $password" } // Log.i jika di tulis pada java
        if (username.equals("test") && password.equals("test123")) {
            toast("Welcome Aboard $username")
        }else{
            alert(title = "Warning", message = "password atau username salah!"){
                positiveButton(buttonText = "OK"){
                    //
                }
                isCancelable = false
            }.show()
        }
    }
}