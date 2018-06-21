package com.example.javapop.java_pop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_viewholder.view.*

class RepositoriesAdapter(val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_viewholder, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.nameRepositories?.text = items.get(position)
        holder?.description?.text = items.get(position)
        holder?.userName?.text = items.get(position)
        holder?.lastName?.text = items.get(position)
        holder?.numberFork?.text = items.get(position)
        holder?.numberFavorite?.text = items.get(position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameRepositories = view.tv_nameRepositories
        val description = view.tv_description
        val userName = view.tv_username
        val lastName = view.tv_lastName
        val numberFork = view.tv_numberFork
        val numberFavorite = view.tv_numberFavorite

    }
}
