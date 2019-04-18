package com.logicgear.appofthrones

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class CharactersAdapter: RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val items = mutableListOf<Character>()

    override fun onBindViewHolder(p0: CharacterViewHolder, p1: Int) {

    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CharacterViewHolder {


    }

    override fun getItemCount(): Int {

    }

    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

}