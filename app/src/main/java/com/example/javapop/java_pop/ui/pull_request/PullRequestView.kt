package com.example.javapop.java_pop.ui.pull_request

import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.ui.base.BaseView

interface PullRequestView  : BaseView {
    fun setPullRequests(items: List<PullRequest>)
}