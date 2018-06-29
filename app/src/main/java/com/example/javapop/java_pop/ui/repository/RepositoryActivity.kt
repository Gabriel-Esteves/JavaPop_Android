package com.example.javapop.java_pop.ui.repository

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.Repository
import com.example.javapop.java_pop.ui.base.BaseActivity
import com.example.javapop.java_pop.ui.pull_request.EndlessScrollRequest
import com.example.javapop.java_pop.ui.pull_request.PullRequestActivity
import kotlinx.android.synthetic.main.activity_main.*

class RepositoryActivity : BaseActivity(), RepositoryView, RepositoriesAdapter.OnRepositorySelectedListener {

    private val adapter = RepositoriesAdapter(this)

    private lateinit var presenter: RepositoryPresenter
    private val linearLayoutManager = LinearLayoutManager(this)

    private lateinit var onScrollListener: RecyclerView.OnScrollListener
    private var countPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_listRepositories.layoutManager = linearLayoutManager
        rv_listRepositories.adapter = adapter

        presenter = RepositoryPresenter(this)
        presenter.getRepository(countPage)

        addListeners()
    }

    fun addListeners() {
        onScrollListener = object : EndlessScrollRequest(linearLayoutManager) {
            override fun onLoadMore(current_page: Int) {
                countPage = current_page
                presenter.getRepository(countPage)
            }
        }
        rv_listRepositories.addOnScrollListener(onScrollListener)
    }

    override fun setRepositories(items: ArrayList<Repository>) {
        adapter.setItems(items)
    }

    override fun onLoadingStart() {
        showProgress()
    }

    override fun onLoadingFinish() {
        hideProgress()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun itemSelected(item: Repository) {
        val intent = Intent(this, PullRequestActivity::class.java)
        intent.putExtra("repository", item)
        startActivity(intent)
    }

//    private fun getItems(): ArrayList<Repository> {
//        return arrayListOf(
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4")),
//                Repository("Repo 1", "description", 1215, 154, Owner("owner1", "https://avatars1.githubusercontent.com/u/582346?v=4"))
//        )
//    }

}
