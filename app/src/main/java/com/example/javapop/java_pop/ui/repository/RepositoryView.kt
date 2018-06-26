package com.example.javapop.java_pop.ui.repository

import com.example.javapop.java_pop.data.model.Repository
import com.example.javapop.java_pop.ui.base.BaseView

interface RepositoryView : BaseView {

    fun setRepositories(items: ArrayList<Repository>)

}