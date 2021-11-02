package kr.yooreka.practice.domain.usecase

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.repository.GithubRepository


class ReposUseCase (private val repository: GithubRepository) {
    fun getRepositories(userName : String) : Flowable<PagingData<ReposVO>> {
        return repository.getRepositories(userName)
    }
}