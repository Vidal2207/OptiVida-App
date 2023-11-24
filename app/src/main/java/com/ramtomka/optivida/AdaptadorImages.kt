package com.ramtomka.optivida

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorImages(private val context: Context?, private val dataList: List<Images>) :
    RecyclerView.Adapter<AdaptadorImages.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.textView.text = item.text

        // Agregar un listener de clic para abrir el video de YouTube
        holder.itemView.setOnClickListener {
            val videoId = item.youtubeVideoId
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
            intent.putExtra("VIDEO_ID", videoId)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
