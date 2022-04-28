package com.globant.marvelcharacters.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.globant.marvelcharacters.R
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel

class MarvelCharacterListAdapter :
    RecyclerView.Adapter<MarvelCharacterListAdapter.MarvelCharacterNameViewHolder>() {

    private var characterNameList: List<MarvelCharacterNameModel>? = emptyList()
    private var listener: ((MarvelCharacterNameModel) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelCharacterNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_marvel_character_list_view, parent, false)
        return MarvelCharacterNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarvelCharacterNameViewHolder, position: Int) {
        holder.textView.text = characterNameList?.get(position)?.name
        holder.textView.setOnClickListener {
            listener?.let {
                it(this.characterNameList?.get(position)!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return characterNameList?.size ?: 0
    }

    fun itemClickListener(l: (MarvelCharacterNameModel) -> Unit) {
        listener = l
    }

    fun setList(list: List<MarvelCharacterNameModel>?) {
        characterNameList = list
        notifyDataSetChanged()
    }

    class MarvelCharacterNameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewName)
    }
}