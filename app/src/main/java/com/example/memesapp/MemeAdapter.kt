package com.example.memesappimport


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memesapp.Meme
import com.example.memesapp.MemeModel
import com.example.memesapp.R
import com.squareup.picasso.Picasso

class MemeAdapter(private val list: List<Meme>) :
    RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeAdapter.MemeViewHolder {
        return MemeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.meme_layout,
                parent,
                false
            )
        )
    }

    class MemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var memeImage: ImageView = itemView.findViewById(R.id.imageView)
        var memeName: TextView = itemView.findViewById(R.id.textView)



    }
    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val item = list[position]

        holder.memeName.text = item.name
        Picasso.get().load(item.url).into(holder.memeImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }


}