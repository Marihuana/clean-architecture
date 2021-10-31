package kr.yooreka.practice.domain.usecase

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.repository.GithubRepository


class ReposUseCase (private val gitHubRepository: GithubRepository) {   //Impl 어떻게 주입해야할지...
    fun getRepositories(userName : String) : Single<List<ReposVO>> {
        return gitHubRepository.getRepositories(userName)
            .onErrorReturn {
                it.printStackTrace()
                listOf()
            }
    }
}