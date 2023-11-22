package com.ramtomka.optivida

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView


class MultimediaFragment : Fragment(R.layout.fragment_multimedia) {

    private val fd by lazy {
        requireContext().assets.openFd("Vigilia.mp3")
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.NavigationViewMusic)
        // Check botón de play
        bottomNavigationView.menu.findItem(R.id.item_play)?.isChecked = true

        // Interacción de los botones de reproducción
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_skip_before -> {
                    // CANCIÓN ANTERIOR
                    Toast.makeText(requireContext(), "BEFORE", Toast.LENGTH_SHORT).show()
                }
                R.id.item_play -> {
                    // PLAY O PAUSE
                    playClicked(view, bottomNavigationView.menu.findItem(R.id.item_play))
                }
                R.id.item_skip_next -> {
                    // CANCIÓN SIGUIENTE
                    Toast.makeText(requireContext(), "NEXT", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    fun playClicked(view: View, playMenuItem: MenuItem) {
        if (!mp.isPlaying) {
            mp.start()
            playMenuItem.setIcon(R.drawable.baseline_pause_circle_24)
        } else {
            mp.pause()
            playMenuItem.setIcon(R.drawable.baseline_play_circle_24)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }
}

