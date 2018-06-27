package com.example.javapop.java_pop.ui.repository

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.Repository
import com.example.javapop.java_pop.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class RepositoryActivity : BaseActivity(), RepositoryView, RepositoriesAdapter.OnRepositorySelectedListener {

    private val adapter = RepositoriesAdapter(this)

    private lateinit var presenter: RepositoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_listRepositories.layoutManager = LinearLayoutManager(this)
        rv_listRepositories.adapter = adapter

        presenter = RepositoryPresenter(this)
        presenter.subscribe()
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
        // TODO Abrir a segunda activity passando o item no bundle

    }

//
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
