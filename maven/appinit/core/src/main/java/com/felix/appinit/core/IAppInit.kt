package com.felix.appinit.core

import android.app.Application

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.appinit.core
 * @ClassName: IAppInit
 * @Author: 80341341
 * @CreateDate: 2021/8/13 10:47
 * @Description: IAppInit 类作用描述
 */
interface IAppInit {
    fun onCreate(app: Application, flavor: String, vararg args: String)
}