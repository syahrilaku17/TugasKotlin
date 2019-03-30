package com.example.pertemuanandroid8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuanandroid8.otherway.AfterLogin
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            handleLogin(username, password)

        }
        tv_ca.setOnClickListener {
            toast("Pindah Ke halaman register")
            startActivity(intentFor<Register>())
        }
    }
    private fun  handleLogin(username : String, password : String){
        info { "data Username : $username, data Password : $password" } // Log.i jika di tulis pada java
        if (username.equals("Syahril Irfani Fattah") && password.equals("test123")) {
            toast("Welcome Aboard $username")
            startActivity(intentFor<AfterLogin>("kode" to username))
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
