package com.example.javapop.java_pop.ui.base

import com.example.javapop.java_pop.data.source.GithubRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {

    val githubRepository = GithubRepository()

    private val mCompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    open fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    abstract fun subscribe()

}