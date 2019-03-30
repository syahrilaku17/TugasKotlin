package com.example.pertemuanandroid8

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        btn.setOnClickListener {
            val fullname = et_fullname.text.toString().trim()
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            hadleRegisiter(fullname, username, password)
        }
    }

    private fun hadleRegisiter(fullname : String, username : String, password : String){
        info { "Fullname : $fullname, \n Username : $username, \n Password : $password" }
        when{
            fullname.isEmpty() -> toast("Fullname Belum di isi")
            username.isEmpty() -> toast("Username Belum di isi")
            password.isEmpty() -> toast("Password Belum di isi")
            else -> alert(title = "Register", message = "Account baru di tambahkan") {
                positiveButton(buttonText = "OK"){
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }
}