package kr.yooreka.practice.cleancodepractice.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.yooreka.practice.domain.usecase.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase : SearchUseCase) : ViewModel() {

}