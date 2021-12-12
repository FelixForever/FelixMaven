package com.felix.maven

import android.app.Application
import android.util.Log
import com.felix.appinit.annotation.AppInitImpl
import com.felix.appinit.core.IAppInit
import com.felix.utils.utils.ITAG

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.maven
 * @ClassName: Test3
 * @Author: 80341341
 * @CreateDate: 2021/8/13 11:04
 * @Description: Test3 类作用描述
 */
@AppInitImpl
class Test3 : IAppInit, ITAG {
    override fun onCreate(app: Application, flavor: String, vararg args: String) {
        Log.i(TAG, "onCreate: init with Test3")
    }
}