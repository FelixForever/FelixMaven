package com.felix.version

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.version
 * @ClassName: Version
 * @Author: 80341341
 * @CreateDate: 2021/8/9 21:20
 * @Description: Version 类作用描述
 */
object Compile {
    const val compileSdk = 29
    const val buildSdk = "29.0.3"
    const val targetSdk = 29
    const val minSdk = 26
}

object Felix {
    private const val versionCode = 10008
    private const val versionName = "1.0.8"


    const val UtilsVersionCode = versionCode
    const val UtilsVersionName = versionName

    const val ArchVersionCode = versionCode
    const val ArchVersionName = versionName


    const val utils = "com.felix.utils:felix-utils:$UtilsVersionName"
    const val arch = "com.felix.arch:felix-arch:$ArchVersionName"
}