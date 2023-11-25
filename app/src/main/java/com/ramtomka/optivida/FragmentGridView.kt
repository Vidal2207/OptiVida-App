package com.ramtomka.optivida

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.GridView
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
        textViewCategoria.text = categoria


        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val array = ArrayList<Images>()
        array.add(Images(R.drawable.meditar1, "Meditar"))
        array.add(Images(R.drawable.meditar2, "Meditar"))
        array.add(Images(R.drawable.meditar3, "Meditar"))

        // Configurar el RecyclerView con un GridLayoutManager
        val layoutManager = GridLayoutManager(context, 2) // Puedes ajustar el número de columnas según tus necesidades
        recyclerView.layoutManager = layoutManager

        // Crear adaptador para el RecyclerView
        val adapter = AdaptadorClass(requireContext(),array)
        recyclerView.adapter = adapter
    }
}
