package com.example.javapop.java_pop.data.source

import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.data.model.RepositoryResponse
import io.reactivex.Observable

class GithubRepository {

    private val githubRepository = RetrofitClient.getRetrofitClient()

    fun getRepositories(page: Int): Observable<RepositoryResponse> {
        return githubRepository.getRepositories(page)
    }

    fun getPullRequestByRepository(owner: String, repository: String): Observable<List<PullRequest>> {
        return githubRepository.getPullRequestByRepository(owner, repository)
    }

}