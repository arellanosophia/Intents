package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.intents.OtherActivity
import com.example.intents.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginButton).setOnClickListener{ login() }

    }

    private fun login(){
        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)

        val un = username.text
        val pass = password.text

/*
        val u_n = un.equals("Sophia")
        val p_s = pass.equals("1234")
*/

        if(un.toString() =="Sophia" && pass.toString() == "1234" ){
            Toast.makeText(this, "Hello $un", Toast.LENGTH_SHORT).show()
            val intentLogin = Intent( this, OtherActivity::class.java)
            startActivity(intentLogin)
        }else{
            Toast.makeText(this, "Please try again.", Toast.LENGTH_SHORT).show()
        }
    }


}
