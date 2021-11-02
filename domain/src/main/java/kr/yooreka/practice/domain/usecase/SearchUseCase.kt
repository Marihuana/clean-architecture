package kr.yooreka.practice.domain.usecase

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.repository.GithubRepository

class SearchUseCase (private val repository: GithubRepository) {
    fun searchUsers(query : String, page : Int) : Flowable<PagingData<UserVO>> {
        return repository.searchUser(query, page)
    }
}