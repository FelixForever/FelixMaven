package com.felix.utils.utils

import com.felix.utils.AppProxy

/**
 *
 * @ProjectName: FelixUtils
 * @Package: com.felix.utils.utils
 * @ClassName: DensityUtils
 * @Author: 80341341
 * @CreateDate: 2021/7/27 10:25
 * @Description: DensityUtils类作用描述
 */
fun Float.toDp(): Float {
    val density = AppProxy.resources.displayMetrics.density
    return this / density
}

fun Int.toDp(): Float {
    val density = AppProxy.resources.displayMetrics.density
    return this / density
}

fun Float.toSp(): Float {
    val density = AppProxy.resources.displayMetrics.scaledDensity
    return this / density
}

fun Int.toSp(): Float {
    val density = AppProxy.resources.displayMetrics.scaledDensity
    return this / density
}

fun Float.toPx(): Float {
    val density = AppProxy.resources.displayMetrics.density
    return this * density
}

fun Int.toPx(): Float {
    val density = AppProxy.resources.displayMetrics.density
    return this * density
}
