package com.felix.utils.utils.encrypt

import java.security.MessageDigest

/**
 *
 * @ProjectName: FelixMaven
 * @Package: com.felix.utils.utils.encryption
 * @ClassName: Md5Utils
 * @Author: 80341341
 * @CreateDate: 2021/8/9 16:02
 * @Description: Md5Utils 类作用描述
 */
fun String.md5(): String? {
    return this.runCatching {
        MessageDigest.getInstance("MD5").digest(this.toByteArray())
    }.also {
        it.exceptionOrNull()?.printStackTrace()
    }.getOrNull()?.let { hash ->
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            if (b.toInt() and 0xFF < 0x10) {
                hex.append("0")
            }
            hex.append(Integer.toHexString(b.toInt() and 0xFF))
        }
        hex.toString()
    }
}