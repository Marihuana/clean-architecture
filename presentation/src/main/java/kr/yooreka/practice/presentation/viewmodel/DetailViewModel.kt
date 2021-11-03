package kr.yooreka.practice.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.usecase.ReposUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val useCase : ReposUseCase) : BaseViewModel() {

    private val _items = MutableLiveData<PagingData<ReposVO>>()
    val items : MutableLiveData<PagingData<ReposVO>> get() = _items

    fun getRepositories(userName : String){
        if(userName.isNotEmpty()){
            val disposable = useCase.getRepositories(userName)
                .cachedIn(viewModelScope)
                .subscribe(::onSuccess, ::onError)

            addDispose(disposable)
        }
    }
    private fun onSuccess(data : PagingData<ReposVO>){
        _items.value = data
    }
}