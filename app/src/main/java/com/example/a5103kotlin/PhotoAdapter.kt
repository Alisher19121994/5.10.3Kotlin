package com.example.a5103kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(var context: Context, var list: ArrayList<Photo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val photo = list[position]

        if (holder is PhotoViewHolder) {
            holder.photo.setImageResource(photo.photo)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PhotoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val photo: ImageView = item.findViewById(R.id.photo_id)
    }
}