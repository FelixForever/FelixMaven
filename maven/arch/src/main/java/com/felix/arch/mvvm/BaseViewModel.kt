package com.felix.arch.mvvm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.felix.utils.utils.ITAG

open class BaseViewModel : ViewModel(), LifecycleObserver, ITAG {
//    val scope = MainScope()
//
//    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
//    fun destory() {
//        scope.cancel()
//    }

    val result = MutableLiveData<ResultBean>()
}