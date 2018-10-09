package com.example.javapop.java_pop.ui.pull_request

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.javapop.java_pop.R
import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.data.model.Repository
import com.example.javapop.java_pop.ui.base.BaseActivity
import kotlinx.android.synthetic.main.frame_name_repositories.*

class PullRequestActivity : BaseActivity(), PullRequestView, PullRequestAdapter.OnRequestSelectedListener {

    private val adapter = PullRequestAdapter(this)
    private lateinit var presenter: PullRequestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_name_repositories)

        rv_pullRequest.layoutManager = LinearLayoutManager(this)
        rv_pullRequest.adapter = adapter

        val item = intent.getSerializableExtra("repository") as Repository
        showMessage(item.name)

        presenter = PullRequestPresenter(this)
        presenter.getPullRequests(item.owner.login, item.name)
    }

    override fun setPullRequests(items: List<PullRequest>) {
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

    override fun itemSelected(item: PullRequest) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(item.url)
        startActivity(intent)
    }

}