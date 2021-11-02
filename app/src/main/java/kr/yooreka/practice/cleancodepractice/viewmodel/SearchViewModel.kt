package kr.yooreka.practice.cleancodepractice.viewmodel

import androidx.lifecycle.ViewModel
import kr.yooreka.practice.domain.usecase.SearchUseCase

class SearchViewModel(val searchUseCase : SearchUseCase) : ViewModel() {

}