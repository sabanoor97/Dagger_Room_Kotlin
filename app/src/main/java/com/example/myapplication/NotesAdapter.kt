package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context: Context) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    var notesList: List<Notes>? = null

//    fun submitList(mList: List<Notes>) {
//        this.notesList = mList
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_items,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return notesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(notesList?.get(position)!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.tv_title)
        var description = itemView.findViewById<TextView>(R.id.tv_description)
        fun bind(data: Notes) {
            title.text = data.title
            description.text = data.description
        }
    }
}