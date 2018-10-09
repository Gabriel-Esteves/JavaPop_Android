package com.example.javapop.java_pop.ui.pull_request

import com.example.javapop.java_pop.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PullRequestPresenter(val view: PullRequestView) : BasePresenter() {

    override fun subscribe() {}

    fun getPullRequests(owner: String, repository: String) {
        view.onLoadingStart()
        addDisposable(githubRepository.getPullRequestByRepository(owner, repository)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setPullRequests(it)
                }, {
                    // erro
                    view.showMessage(it.message)
                }, {
                    view.onLoadingFinish()
                })


        )
    }


}
