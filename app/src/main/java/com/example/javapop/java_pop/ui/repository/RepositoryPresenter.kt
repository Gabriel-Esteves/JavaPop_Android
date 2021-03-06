package com.example.javapop.java_pop.ui.repository

import com.example.javapop.java_pop.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryPresenter(val view: RepositoryView): BasePresenter() {

    override fun subscribe() {}

    fun getRepository(page: Int) {
        // view.onLoadingStart()
        addDisposable(githubRepository.getRepositories(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // OK
                    view.setRepositories(it.items)
                }, {
                    // ERRO
                    view.showMessage(it.message)
                }, {
            //        view.onLoadingFinish()
                }))
    }

}