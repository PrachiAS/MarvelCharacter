package com.globant.marvelcharacters.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.globant.marvelcharacters.R

class ComicListAdapter(
) :
    RecyclerView.Adapter<ComicListAdapter.ComicNameViewHolder>() {

    private var comicNameList: List<String>? = emptyList()

    class ComicNameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewName)
    }

    fun setList(list: List<String>?) {
        comicNameList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_name_list_row, parent, false)
        return ComicNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicNameViewHolder, position: Int) {
        holder.textView.text = comicNameList?.get(position) ?: ""
    }

    override fun getItemCount(): Int {
        return comicNameList?.size ?: 0
    }
}