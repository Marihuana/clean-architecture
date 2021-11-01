package kr.yooreka.practice.data.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.yooreka.practice.data.repository.GithubRepositoryImpl
import kr.yooreka.practice.domain.repository.GithubRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideGithubRepository(repository : GithubRepositoryImpl) : GithubRepository
}