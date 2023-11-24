package com.ramtomka.optivida

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.IOException


class MultimediaFragment : Fragment(R.layout.fragment_multimedia) {

    private val fd by lazy {
        requireContext().assets.openFd(cancionActual)
    }

    private val mp by lazy {
        MediaPlayer().apply {
            try {
                setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
                fd.close()
                prepare()
            } catch (e: Exception) {
                // Manejar la excepción, por ejemplo, mostrar un mensaje de error
                e.printStackTrace()
            }
        }
    }

    private val nameCancion by lazy {
        requireView().findViewById<TextView>(R.id.textCancion)
    }

    private val canciones by lazy {
        val nombreFicheros = requireContext().assets.list("")?.toList() ?: listOf()
        nombreFicheros.filter { it.endsWith(".mp3") }
    }

    var cancionActualIndex = 0
        set(value) {
            field = if (value == -1) {
                canciones.size - 1
            } else {
                value % canciones.size
            }
            cancionActual = canciones[field]
        }

    lateinit var cancionActual: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancionActual = "Vigilia.mp3"

        cancionActual = canciones[cancionActualIndex]
        nameCancion.text = cancionActual

        val recyclerView = view.findViewById<RecyclerView>(R.id.recicleViewSongs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.NavigationViewMusic)
        // Check botón de play
        bottomNavigationView.menu.findItem(R.id.item_play)?.isChecked = true

        val adaptadorCanciones = AdaptadorCanciones(requireContext(), canciones)
        recyclerView.adapter = adaptadorCanciones


        adaptadorCanciones.setOnItemClickListener(object : AdaptadorCanciones.OnItemClickListener {
            override fun onItemClick(position: Int) {
                cancionActualIndex = position
                refreshSong()
                playClicked(bottomNavigationView.menu.findItem(R.id.item_play))
            }
        })

        // Interacción de los botones de reproducción
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_skip_before -> {
                    // CANCIÓN ANTERIOR
                    cancionActualIndex++
                    refreshSong()
                    playClicked(bottomNavigationView.menu.findItem(R.id.item_play))
                }
                R.id.item_play -> {
                    // PLAY O PAUSE
                    playClicked(bottomNavigationView.menu.findItem(R.id.item_play))
                }
                R.id.item_skip_next -> {
                    // CANCIÓN SIGUIENTE
                    cancionActualIndex--
                    refreshSong()
                    playClicked(bottomNavigationView.menu.findItem(R.id.item_play))
                }
            }
            true
        }
    }
    fun playClicked(playMenuItem: MenuItem) {
        if (!mp.isPlaying) {
            mp.start()
            playMenuItem.setIcon(R.drawable.baseline_pause_circle_24)
        } else {
            mp.pause()
            playMenuItem.setIcon(R.drawable.baseline_play_circle_24)
        }
    }
    fun refreshSong() {
        mp.reset()
        try {
            val fd = requireContext().assets.openFd(cancionActual)
            mp.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
            mp.prepare()
            fd.close()
            nameCancion.text = cancionActual
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


}

