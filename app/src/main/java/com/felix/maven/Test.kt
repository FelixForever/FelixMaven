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
 * @ClassName: Test
 * @Author: 80341341
 * @CreateDate: 2021/8/11 17:30
 * @Description: Test 类作用描述
 */
@AppInitImpl
class Test : IAppInit, ITAG {
    override fun onCreate(app: Application, flavor: String, vararg args: String) {
        Log.i(TAG, "onCreate: init with Test")
    }
}