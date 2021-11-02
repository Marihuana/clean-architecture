package kr.yooreka.practice.data.repository.paging

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.yooreka.practice.data.mapper.ReposMapper
import kr.yooreka.practice.data.service.GithubService
import kr.yooreka.practice.domain.model.ReposVO

class ReposPagingSource(private val service: GithubService) : RxPagingSource<Int, ReposVO>(){
    private val pageSize = 30
    var query = ""

    override fun getRefreshKey(state: PagingState<Int, ReposVO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ReposVO>> {
        val page = params.key ?: 1

        return service.getRepositories(query)
            .subscribeOn(Schedulers.io())
            .map ( ReposMapper::transform )
            .map { toLoadResult(page, it) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(page : Int, list : List<ReposVO>) : LoadResult<Int, ReposVO>{
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = page + (list.size / pageSize)
        )
    }
}