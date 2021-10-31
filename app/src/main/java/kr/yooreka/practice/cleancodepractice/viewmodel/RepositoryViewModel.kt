package kr.yooreka.practice.cleancodepractice.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.yooreka.practice.domain.usecase.ReposUseCase

@HiltViewModel
class RepositoryViewModel(val useCase : ReposUseCase) : ViewModel() {


}