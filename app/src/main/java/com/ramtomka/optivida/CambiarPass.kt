package com.ramtomka.optivida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CambiarPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiarpassword)

        val btnLogin = findViewById<Button>(R.id.btn)
        val btnReenviar = findViewById<TextView>(R.id.textView5)



        btnLogin.setOnClickListener{
            //INICIAR OTRA ACTIVIDAD
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnReenviar.setOnClickListener{
            val alert:String = "Se ha reenviado un nuevo codigo"
            Toast.makeText(this,alert, Toast.LENGTH_SHORT).show()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Otros comportamientos personalizados, si es necesario
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }

}