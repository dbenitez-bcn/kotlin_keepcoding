package com.logicgear.appofthrones

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CharactersFragment : Fragment() {

    val list: RecyclerView by lazy {
        val list: RecyclerView = view!!.findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(context)
        list
    }

    val adapter: CharactersAdapter by lazy {
        val adapter = CharactersAdapter { item, positon ->
            clickListener.onItemClicked(item)

        }
        adapter
    }

    lateinit var clickListener: OnItemClickListener
    
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is OnItemClickListener){
            clickListener = context
        }else{
            throw IllegalArgumentException("Attached activity doesn't implement CharacterFragment.OnItemClickListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frament_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characters: MutableList<Character> = CharactersRepo.characters
        adapter.setCharacters(characters)

        list.adapter = adapter
    }


    interface OnItemClickListener {
        fun onItemClicked(character: Character)
    }
}