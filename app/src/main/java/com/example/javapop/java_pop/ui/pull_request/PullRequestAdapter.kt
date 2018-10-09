package com.example.javapop.java_pop.ui.pull_request

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.PullRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_request_viewholder.view.*

class PullRequestAdapter(
        private val listener: OnRequestSelectedListener
) : RecyclerView.Adapter<PullRequestAdapter.RequestViewHolder>() {

    private var items = ArrayList<PullRequest>()

    fun setItems(items: List<PullRequest>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_request_viewholder, parent, false)
        return RequestViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)

        holder.itemView.setOnClickListener {
            listener.itemSelected(item)
        }
    }

    class RequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: PullRequest) {
            with(itemView) {
                tv_title_resquest.text = item.title
                tv_description_request.text = item.created_at

                val owner = item.owner
                tv_username_Request.text = owner.login

                Picasso.with(itemView.context).load(item.owner.avatarUrl).placeholder(R.drawable.icon_user).error(R.drawable.icon_user).into(civ_imageUserRequest)
            }
        }
    }

    interface OnRequestSelectedListener {
        fun itemSelected(item: PullRequest)
    }
}