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

        val btnRegistrar = findViewById<TextView>(R.id.registrar)

        btnLogin.setOnClickListener{
            //INICIAR OTRA ACTIVIDAD

            val intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)

        }

        btnOlvidar.setOnClickListener {
            val intent = Intent(this, CambiarPass::class.java)
            startActivity(intent)
            finish()
        }

        btnRegistrar.setOnClickListener {
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
            finish()
        }
    }
}