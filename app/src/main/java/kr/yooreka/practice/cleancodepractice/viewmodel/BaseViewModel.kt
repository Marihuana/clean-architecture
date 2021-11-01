package kr.yooreka.practice.cleancodepractice.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    protected fun addDispose(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    private fun disposeAll(){
        compositeDisposable.run {
            if(!isDisposed) dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposeAll()
    }
}