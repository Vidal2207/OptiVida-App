package com.ramtomka.optivida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btn)

        val btnOlvidar = findViewById<TextView>(R.id.OlvidarPass)

        btnLogin.setOnClickListener{
            //INICIAR OTRA ACTIVIDAD
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnOlvidar.setOnClickListener {
            val intent = Intent(this, CambiarPass::class.java)
            startActivity(intent)
            finish()
        }
    }
}