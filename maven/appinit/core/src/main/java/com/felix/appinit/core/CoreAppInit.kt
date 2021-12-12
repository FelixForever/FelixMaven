package com.felix.appinit.core

import android.app.Application

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.appinit.core
 * @ClassName: CoreAppInit
 * @Author: 80341341
 * @CreateDate: 2021/8/13 11:33
 * @Description: CoreAppInit 类作用描述
 */
class CoreAppInit : IAppInit {
    override fun onCreate(app: Application, flavor: String, vararg args: String) {
        Loader.list.forEach {
            it.onCreate(app, flavor, *args)
        }
    }
}