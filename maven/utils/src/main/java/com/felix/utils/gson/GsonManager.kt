package com.felix.utils.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class GsonManager private constructor() {
    companion object {
        val instance by lazy { GsonManager() }
    }

    val gson: Gson = Gson()
}

val GsonProxy
    get() = GsonManager.instance.gson

@Suppress("unused")
fun <T> T.toJson(): String = GsonProxy.toJson(this) ?: ""

@Suppress("unused")
inline fun <reified T> String.fromJson(): T? =
    GsonProxy.fromJson<T>(this, object : TypeToken<T>() {}.type)