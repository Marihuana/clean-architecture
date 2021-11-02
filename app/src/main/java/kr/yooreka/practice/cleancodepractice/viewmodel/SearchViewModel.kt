package kr.yooreka.practice.cleancodepractice.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.usecase.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase : SearchUseCase) : BaseViewModel() {
    private var currentPage : Int = 0
    val inputText = ObservableField("")

    private val _items = MutableLiveData<PagingData<UserVO>>()
    val items : MutableLiveData<PagingData<UserVO>> get() = _items

    @ExperimentalCoroutinesApi
    fun search(){
        val query = inputText.get()?.trim()

        query?.also {
            if(it.isNotEmpty()){
                currentPage = 0
                val disposable = useCase.searchUsers(it, currentPage++)
                    .cachedIn(viewModelScope)
                    .subscribe(::onSuccess, ::onError)

                addDispose(disposable)
            }
        }
    }

    private fun onSuccess(data : PagingData<UserVO>){
        _items.value = data
    }
}