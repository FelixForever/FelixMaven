package com.felix.appinit.core

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.appinit.core
 * @ClassName: Loader
 * @Author: 80341341
 * @CreateDate: 2021/8/13 10:57
 * @Description: Loader 类作用描述
 */
object Loader {
    val list = hashSetOf<IAppInit>()
    fun put(iAppInit: IAppInit) {
        list.add(iAppInit)
    }
}