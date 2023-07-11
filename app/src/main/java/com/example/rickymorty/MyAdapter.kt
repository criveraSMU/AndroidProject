package com.example.rickymorty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickymorty.models.Result
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val characterList: List<Result>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView){

        //PERSONAJES
        var nameTextView : TextView = itemView.findViewById(R.id.nameTextView)
        var genderTextView : TextView = itemView.findViewById(R.id.genderTextView)
        var locationTextView : TextView = itemView.findViewById(R.id.locationTextView)
        var statusTextView : TextView = itemView.findViewById(R.id.statusTextView)
        var speciesTextView : TextView = itemView.findViewById(R.id.speciesTextView)
        var episodeTextView : TextView = itemView.findViewById(R.id.episodeTextView)
        var imageView : ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_character, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        var character = characterList[position]

        //PERSONAJES
            holder.nameTextView.text = character.name
            holder.genderTextView.text = "Gender: " + character.gender
            holder.locationTextView.text = "Location: " + character.location.name
            holder.statusTextView.text = "Status: " + character.status
            holder.speciesTextView.text = "Species: " + character.species
            holder.episodeTextView.text = "Cast in: " + character.episode.size.toString() + " Episodies"
            Picasso.get().load(character.image).into(holder.imageView);
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}

