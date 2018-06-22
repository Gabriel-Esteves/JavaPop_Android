package com.example.javapop.java_pop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_viewholder.view.*

class RepositoriesAdapter(items: ArrayList<String>,
                          context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = items
    private val context = context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_viewholder, parent, false)
        return ViewHolder(view)
        TODO("not impleme¥nted") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(view: View, position: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.nameRepositories?.text = items.get(position)
        holder?.description?.text = items.get(position)
        holder?.userName?.text = items.get(position)
        holder?.lastName?.text = items.get(position)
        holder?.numberFork?.text = items.get(position)
        holder?.numberFavorite?.text = items.get(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameRepositories = itemView.tv_nameRepositories
        val description = itemView.tv_description
        val userName = itemView.tv_username
        val lastName = itemView.tv_lastName
        val numberFork = itemView.tv_numberFork
        val numberFavorite = itemView.tv_numberFavorite

    }
}
