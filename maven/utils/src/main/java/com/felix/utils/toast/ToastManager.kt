package com.felix.lib_app_tools.toast

import android.view.Gravity
import android.widget.Toast
import com.felix.utils.AppDelegate
import com.felix.utils.handler.UIDelegate
import com.felix.utils.handler.UIProxy

internal class ToastManager private constructor() : IToast {
    companion object {
        val instance: ToastManager by lazy {
            ToastManager()
        }
    }

    private lateinit var toast: Toast

    init {
        UIProxy.post {
            toast = Toast.makeText(AppDelegate, "", Toast.LENGTH_SHORT)
        }
    }

    override fun show(msg: String?, duration: Int, gravity: Int) {
        msg?.takeIf { it.isNotEmpty() }?.let {
            UIProxy.post {
                toast.setText(msg)
                toast.duration = duration
                toast.setGravity(gravity, 0, 0)
                toast.show()
            }
        }
    }

    override fun show(resId: Int, duration: Int, gravity: Int) {
        resId.takeIf { it > 0 }?.let {
            UIProxy.post {
                toast.setText(resId)
                toast.duration = duration
                toast.setGravity(gravity, 0, 0)
                toast.show()
            }
        }
    }
}

val ToastDelegate: IToast
    get() = ToastProxy

val ToastProxy: IToast
    get() = ToastManager.instance

@Suppress("unused")
fun String.showToast(duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.CENTER) {
    ToastDelegate.show(this, duration, gravity)
}