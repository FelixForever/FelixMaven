package com.felix.arch.mvvm

/**
 * @Author: Mingfa.Huang
 * @Date: 2021/2/20
 * @Des: ResultBean
 */
data class ResultBean(
    var isSuccess: Boolean,
    var code: Int = 0,
    var msg: String = "",
    var data: Any? = null
)