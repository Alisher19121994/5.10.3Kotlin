package com.example.a5103kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.imageview.ShapeableImageView
import java.util.*
import kotlin.collections.ArrayList

class PostAdapter(var context: Context, var list: ArrayList<Main>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var STORY = 0
    private var PHOTO = 1
    private var ADDs = 2


    override fun getItemViewType(position: Int): Int {
        return if (list[position].story.size > 0) STORY else if (list[position].photo.size > 0) PHOTO else ADDs
    }

    private fun storyAdapter(list: LinkedList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, list)
        recyclerView.adapter = adapter
    }

    private fun photoAdapter(list: ArrayList<Photo>, recyclerView: RecyclerView) {
        val adapter = PhotoAdapter(context, list)
        recyclerView.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.story, parent, false)
            return StoryViewHolder(view)
        } else if (viewType == PHOTO) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
            return PhotoViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adds_view, parent, false)
        return AddsViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val main = list[position]

        if (holder is StoryViewHolder) {
            val recyclerView = holder.recyclerView
            storyAdapter(main.story, recyclerView)
            // main.story?.let { storyAdapter(it,recyclerView) }
        }

        if (holder is PhotoViewHolder) {
            val recyclerView = holder.recyclerView
            photoAdapter(main.photo, recyclerView)
        }

           if (holder is AddsViewHolder) {
               holder.car.setImageResource(main.adds!!.adds)
           }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class StoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView: RecyclerView = item.findViewById(R.id.story_recyclerview)

        init {
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class PhotoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView: RecyclerView = item.findViewById(R.id.photo_recyclerview)

        init {
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class AddsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var car: ShapeableImageView = item.findViewById(R.id.car_id)

    }
}