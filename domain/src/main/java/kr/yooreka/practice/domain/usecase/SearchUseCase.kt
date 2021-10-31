package kr.yooreka.practice.domain.usecase

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.repository.GithubRepository

class SearchUseCase (private val gitHubRepository: GithubRepository) {
    private var total : Long = 1

    fun searchUsers(query : String, page : Int) : Single<List<UserVO>>{
        return gitHubRepository.searchUser(query, page)
            .onErrorReturn {
                it.printStackTrace()
                listOf()
            }
    }
}