package com.ramtomka.optivida

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentGridView : Fragment(R.layout.fragment_grid_view) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)

        // Obtener los argumentos del Bundle
        val categoria = arguments?.getString("categoria")
        val textViewCategoria = view.findViewById<TextView>(R.id.tituloCategoria)
        if(categoria=="Todo"){
            textViewCategoria.text = "Todas las categorias"
        }else{
            textViewCategoria.text = categoria}

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val array = ArrayList<Images>()
        when(categoria){
            "Todo" -> {
                array.add(Images(R.drawable.meditar1, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar2, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar3, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar4, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar8, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar2, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar20, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar1, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar3, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar5, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar6, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar7, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar9, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar10, "Estres", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar11, "Estres", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar12, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar13, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar14, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar15, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar16, "Principiantes", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar17, "Zen", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar18, "Zen", "3oCC4NDgYrY"))
            }
            "Meditar" -> {
                array.add(Images(R.drawable.meditar1, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar2, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar3, "Meditar", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar4, "Meditar", "3oCC4NDgYrY"))
            }
            "Ansiedad" -> {
                array.add(Images(R.drawable.meditar8, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar2, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar20, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar1, "Ansiedad", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar3, "Ansiedad", "3oCC4NDgYrY"))
            }
            "Sueño" -> {
                array.add(Images(R.drawable.meditar5, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar6, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar7, "Sueño", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar9, "Sueño", "3oCC4NDgYrY"))
            }
            "Estres" -> {
                array.add(Images(R.drawable.meditar10, "Estres", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar11, "Estres", "3oCC4NDgYrY"))
            }
            "Relaciones" -> {
                array.add(Images(R.drawable.meditar12, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar13, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar14, "Relaciones", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar15, "Relaciones", "3oCC4NDgYrY"))
            }
            "Principiantes" -> {
                array.add(Images(R.drawable.meditar16, "Principiantes", "3oCC4NDgYrY"))
            }
            "Zen" -> {
                array.add(Images(R.drawable.meditar17, "Zen", "3oCC4NDgYrY"))
                array.add(Images(R.drawable.meditar18, "Zen", "3oCC4NDgYrY"))
            }
            else -> {
                array.add(Images(R.drawable.error, "No encontrado", "3oCC4NDgYrY"))
            }
        }
        array.shuffle()
        // Configurar el RecyclerView con un GridLayoutManager
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager

        // Crear adaptador para el RecyclerView
        val adapter = AdaptadorImages(requireContext(),array)
        recyclerView.adapter = adapter
    }
}
