package com.globant.marvelcharacters.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.globant.marvelcharacters.R

class MarvelCharacterListAdapter(
    private val onClickListener: (position: Int) -> Unit
) :
    RecyclerView.Adapter<MarvelCharacterListAdapter.MarvelCharacterListViewHolder>() {

    private var characterNameList: List<String>? = emptyList()

    class MarvelCharacterListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewName)
    }

    fun setList(list: List<String>?) {
        characterNameList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharacterListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_marvel_character_list_view, parent, false)
        return MarvelCharacterListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarvelCharacterListViewHolder, position: Int) {
        holder.textView.text = characterNameList?.get(position) ?: ""
        holder.textView.setOnClickListener {
            onClickListener.invoke(holder.bindingAdapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return characterNameList?.size ?: 0
    }
}