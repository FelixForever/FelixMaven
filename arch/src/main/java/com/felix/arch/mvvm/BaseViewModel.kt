package com.felix.arch.mvvm

import androidx.lifecycle.*
import com.felix.utils.utils.ITAG
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

open class BaseViewModel : ViewModel(), LifecycleObserver, ITAG {
    val scope = MainScope()

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun destory() {
        scope.cancel()
    }

    val result = MutableLiveData<ResultBean>()
}