package com.ramtomka.optivida

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val btnLogin = findViewById<Button>(R.id.btn)


        btnLogin.setOnClickListener{
            //INICIAR OTRA ACTIVIDAD
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
                //Hace que se cierre la aplicacion si hacemos back
            //finish()
        }

        val btnLog =findViewById<Button>(R.id.btn2)

        btnLog.setOnClickListener {
            // INICIAR OTRA ACTIVIDAD
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Otros comportamientos personalizados, si es necesario
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }
}