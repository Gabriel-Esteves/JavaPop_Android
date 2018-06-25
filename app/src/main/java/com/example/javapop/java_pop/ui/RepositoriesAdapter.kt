package com.example.javapop.java_pop.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_viewholder.view.*

class RepositoriesAdapter : RecyclerView.Adapter<RepositoriesAdapter.RepositoriesViewHolder>() {

    private var items = ArrayList<Repository>()

    fun setItems(items: ArrayList<Repository>) {
        this.items.clear()
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RepositoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_viewholder, parent, false)
        return RepositoriesViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    inner class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: Repository) {
            with(itemView) {
                tv_nameRepositories?.text = item.name
                tv_description?.text = item.description
                tv_numberFavorite.text = item.stargazersCount.toString()
                tv_numberFork.text = item.forksCount.toString()

                val owner = item.owner
                tv_username.text = owner.login

                // Glide
                Picasso.with(itemView.context).load(item.owner.avatarUrl).placeholder(R.drawable.icon_user).error(R.drawable.icon_user).into(civ_imageUser)
            }
        }
    }
}