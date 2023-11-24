package com.ramtomka.optivida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// RecordatorioAdapter.kt
class RecordatorioAdapter(private val recordatorios: MutableList<Recordatorio>) :
    RecyclerView.Adapter<RecordatorioAdapter.RecordatorioViewHolder>() {

    class RecordatorioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTituloRecordatorio: TextView = itemView.findViewById(R.id.tvTituloRecordatorio)
        val tvFechaHora: TextView = itemView.findViewById(R.id.tvFechaHora)
        val ivEliminar: ImageView = itemView.findViewById(R.id.ivEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordatorioViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recordatorio, parent, false)
        return RecordatorioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecordatorioViewHolder, position: Int) {
        val recordatorio = recordatorios[position]

        holder.tvTituloRecordatorio.text = recordatorio.titulo
        holder.tvFechaHora.text = "Fecha: ${recordatorio.fecha}, Hora: ${recordatorio.hora}"

        // Configurar la acción de eliminar
        holder.ivEliminar.setOnClickListener {
            recordatorios.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return recordatorios.size
    }
}
