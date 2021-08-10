package com.felix.utils.handler

import android.os.Handler
import android.os.Looper

val UIProxy by lazy {
    Handler(Looper.getMainLooper())
}