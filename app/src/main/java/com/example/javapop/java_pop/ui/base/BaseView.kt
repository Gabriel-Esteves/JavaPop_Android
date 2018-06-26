package com.example.javapop.java_pop.ui.base

interface BaseView {

    fun onLoadingStart()
    fun onLoadingFinish()
    fun showMessage(message: String?)

}