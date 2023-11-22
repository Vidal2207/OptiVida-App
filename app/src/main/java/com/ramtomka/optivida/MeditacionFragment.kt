package com.ramtomka.optivida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView


class MeditacionFragment : Fragment(R.layout.fragment_meditacion) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragViewMeditar = view.findViewById<FragmentContainerView>(R.id.FragViewMeditar)
        // Manejar clics en los botones
        view.findViewById<Button>(R.id.button).setOnClickListener {
            cargarFragmentoContenido("Meditar")
        }
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            cargarFragmentoContenido("Estres")
        }
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            cargarFragmentoContenido("Principiantes")
        }
        view.findViewById<Button>(R.id.button4).setOnClickListener {
            cargarFragmentoContenido("Relaciones")
        }
        view.findViewById<Button>(R.id.button5).setOnClickListener {
            cargarFragmentoContenido("Ansiedad")
        }
        view.findViewById<Button>(R.id.button6).setOnClickListener {
            cargarFragmentoContenido("Sueño")
        }
        view.findViewById<Button>(R.id.button7).setOnClickListener {
            cargarFragmentoContenido("Zen")
        }
        view.findViewById<Button>(R.id.button8).setOnClickListener {
            cargarFragmentoContenido("Todo")
        }
        // Fragmento inicial
        cargarFragmentoContenido("Todo")
    }

    private fun cargarFragmentoContenido(categoria: String) {
        // Crear una instancia del FragmentGridView
        val nuevoFragmento = FragmentGridView()

        // Crear un Bundle para pasar datos al nuevo fragmento
        val bundle = Bundle()
        bundle.putString("categoria", categoria)
        nuevoFragmento.arguments = bundle

        // Iniciar la transacción de fragmentos
        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        // Reemplazar el contenido actual en FragViewMeditar con el nuevo fragmento
        transaction.replace(R.id.FragViewMeditar, nuevoFragmento)

        // Confirmar la transacción
        transaction.commit()
    }
}