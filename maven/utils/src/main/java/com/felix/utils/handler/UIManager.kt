package com.felix.utils.handler

import android.os.Handler
import android.os.Looper

@Deprecated("use UIProxy")
val UIDelegate by lazy {
    Handler(Looper.getMainLooper())
}

val UIProxy by lazy {
    Handler(Looper.getMainLooper())
}