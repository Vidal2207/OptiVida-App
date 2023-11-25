package com.ramtomka.optivida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meditFragment = MeditacionFragment()
        val multiFragment = MultimediaFragment()
        val recordFragment = RecordatorioFragment()
        val perfilFragment = PerfilFragment()


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.item_meditar -> {
                    cargarFragmento(meditFragment)
                    true;
                }
                R.id.item_multimedia -> {
                    cargarFragmento(multiFragment)
                    true;
                }
                R.id.item_recordatorio -> {
                    cargarFragmento(recordFragment)
                    true;
                }
                R.id.item_perfil -> {
                    cargarFragmento(perfilFragment)
                    true;
                }
                else -> false
            }
        }
        bottomNavigationView.getOrCreateBadge(R.id.item_recordatorio).apply{
            isVisible = true
            number = 10
        }
    }

    private fun cargarFragmento(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView,fragment)
            commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Otros comportamientos personalizados, si es necesario
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}