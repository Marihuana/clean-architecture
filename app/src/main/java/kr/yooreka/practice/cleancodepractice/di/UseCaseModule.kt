package kr.yooreka.practice.cleancodepractice.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.yooreka.practice.domain.repository.GithubRepository
import kr.yooreka.practice.domain.usecase.ReposUseCase
import kr.yooreka.practice.domain.usecase.SearchUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesReposUseCase(repository : GithubRepository) : ReposUseCase {
        return ReposUseCase(repository)
    }

    @Provides
    fun providesSearchUseCase(repository : GithubRepository) : SearchUseCase {
        return SearchUseCase(repository)
    }
}