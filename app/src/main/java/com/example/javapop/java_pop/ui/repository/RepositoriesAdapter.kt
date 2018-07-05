package com.example.javapop.java_pop.ui.repository

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_viewholder.view.*

class RepositoriesAdapter(
        private val listener: OnRepositorySelectedListener
) : RecyclerView.Adapter<RepositoriesAdapter.GenericViewHolder>() {

    private var items = ArrayList<Repository>()

    companion object {
        private var TYPE_LOADING = 1
        private var TYPE_ITEM = 2
    }

    fun setItems(items: ArrayList<Repository>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): GenericViewHolder {
        if (position == TYPE_ITEM) {
            val VHItem = LayoutInflater.from(parent.context).inflate(R.layout.list_viewholder, parent, false)
            return RepositoriesViewHolder(VHItem)
        } else if (position == TYPE_LOADING) {
            val VHHeader = LayoutInflater.from(parent.context).inflate(R.layout.progressbar_viewholder, parent, false)
            return LoadingViewHolder(VHHeader)
        }

        throw RuntimeException("Error " + position)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val item = items[position]
        if (holder is RepositoriesViewHolder) {
            holder.bindItem(item)

            holder.itemView.setOnClickListener {
                listener.itemSelected(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return if (item is Repository) {
            TYPE_ITEM
        } else {
            TYPE_LOADING
        }
    }

    open class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class LoadingViewHolder(itemView: View) : GenericViewHolder(itemView)

    inner class RepositoriesViewHolder(itemView: View) : GenericViewHolder(itemView) {
        fun bindItem(item: Repository) {
            with(itemView) {
                tv_nameRepositories?.text = item.name
                tv_description?.text = item.description
                tv_numberFavorite.text = item.stargazersCount.toString()
                tv_numberFork.text = item.forksCount.toString()

                val owner = item.owner
                tv_username_Request.text = owner.login

                // Glide
                Picasso.with(itemView.context).load(item.owner.avatarUrl).placeholder(R.drawable.icon_user).error(R.drawable.icon_user).into(civ_imageUser)
            }
        }
    }

    interface OnRepositorySelectedListener {
        fun itemSelected(item: Repository)
    }
}