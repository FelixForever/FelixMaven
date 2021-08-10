package com.felix.maven

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.felix.lib_app_tools.toast.ToastProxy
import com.felix.utils.utils.ITAG
import com.felix.utils.widget.dialog.IInfoDialog
import com.felix.utils.widget.dialog.ILoadDialog


class MainActivity : AppCompatActivity(), ILoadDialog, IInfoDialog, ITAG {
    override var infoDialog: AlertDialog? = null
    override var progressDialog: ProgressDialog? = null
    override var ctx: Context? = null
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastProxy.show("this is test")
    }
}