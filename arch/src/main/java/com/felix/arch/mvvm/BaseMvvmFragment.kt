package com.felix.arch.mvvm

import android.os.Bundle
import com.felix.lib_arch.mvvm.BaseFragment

open class BaseMvvmFragment<VM : BaseViewModel> : BaseFragment(), BaseMvvmView<VM> {

    override lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }
}