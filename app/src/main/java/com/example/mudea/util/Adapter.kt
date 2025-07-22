package com.example.mudea.util

import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mudea.R
import com.example.mudea.data.Personagens
import java.util.zip.Inflater

class PersonagensAdapter(
    var list: List<Personagens>
) : RecyclerView.Adapter<PersonagensAdapter.PersonagensViewHolder>(){
    inner class PersonagensViewHolder(
        val personagensView: View
    ) : ViewHolder(personagensView){


        val nomePerso: TextView = personagensView.findViewById(R.id.nomePersonagem)
        val nomeAnime: TextView = personagensView.findViewById(R.id.nomeAnime)
        val valks: TextView = personagensView.findViewById(R.id.valksPoint)
        val gender: TextView = personagensView.findViewById(R.id.generoPersonagem)
        val imagePersonagem: ImageView = personagensView.findViewById(R.id.imagePersonagem)

        fun bind(personagem: Personagens){
//        imagemPersonagem.setImageResource(personage.image)
            Glide.with(personagensView.context)
                .load(personagem.imgSrc)
                .centerCrop()
                .into(imagePersonagem)
            nomePerso.text = personagem.nome
            nomeAnime.text = personagem.anime
            valks.text = personagem.valks.toString()
            gender.text = personagem.gender
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonagensAdapter.PersonagensViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(
            R.layout.card_view_album,
            parent,
            false)

        return PersonagensViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PersonagensAdapter.PersonagensViewHolder,
        position: Int
    ) {
        val personagem = list[position]

        holder.bind(personagem)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: List<Personagens>){
        list = newList
        notifyDataSetChanged()
    }

}