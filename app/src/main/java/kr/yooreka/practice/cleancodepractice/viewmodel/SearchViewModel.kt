package kr.yooreka.practice.cleancodepractice.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.usecase.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase : SearchUseCase) : BaseViewModel() {
    private var currentPage : Int = 0
    val inputText = ObservableField("")

    private val _query = MutableLiveData<String>()
    val query : LiveData<String> get() = _query

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

    private val _selectedUser = MutableLiveData<UserVO?>()
    val selectedUser : MutableLiveData<UserVO?> get() = _selectedUser

    private val _items = MutableLiveData<List<UserVO>>()
    val items : MutableLiveData<List<UserVO>> get() = _items

    fun search(){
        _query.value = inputText.get()?.trim()

        query.value?.also {
            if(it.isNotEmpty()){
                currentPage = 0
                useCase.searchUsers(it, currentPage++)
                    .subscribe(::setList, ::errorProcess)
            }
        }
    }

    fun searchMore(){
        query.value?.also {
            if(it.isNotEmpty()){
                useCase.searchUsers(it, currentPage++)
                    .subscribe(::setList, ::errorProcess)
            }
        }
    }

    fun refresh(){
        query.value?.also {
            if(it.isNotEmpty()){
                currentPage = 0
                useCase.searchUsers(it, currentPage++)
                    .subscribe(::setList, ::errorProcess)
            }
        }
    }

    fun setUser(item: UserVO?){
        _selectedUser.value = item
    }

    private fun setList(list : List<UserVO>){
        Log.i("test", "list size : ${list.size}")
    }

    private fun errorProcess(t : Throwable){
        Log.e("error", t.stackTraceToString())
    }
}