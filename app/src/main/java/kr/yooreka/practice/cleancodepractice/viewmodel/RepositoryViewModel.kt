package kr.yooreka.practice.cleancodepractice.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.yooreka.practice.domain.usecase.ReposUseCase
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(val useCase : ReposUseCase) : ViewModel() {


}