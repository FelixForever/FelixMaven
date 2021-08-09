package com.felix.lib_arch.mvvm

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.felix.arch.mvvm.IBackable
import com.felix.utils.utils.ITAG
import com.felix.utils.widget.dialog.IInfoDialog
import com.felix.utils.widget.dialog.ILoadDialog

open class BaseActivity : AppCompatActivity(),
    ILoadDialog, IInfoDialog,
    ITAG {
    override var ctx: Context? = null
        get() = this
    override var progressDialog: ProgressDialog? = null
    override var infoDialog: AlertDialog? = null

    override fun onDestroy() {
        super.onDestroy()
        dismissLoading()
        dismissInfo()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments?.filter {
            it?.let {
                it.isAdded && it.isMenuVisible && !it.isHidden && it is IBackable
            } ?: false
        }?.map { it as IBackable }.forEach {
            if (it.onBackPress()) {
                return
            }
        }
        super.onBackPressed()
    }
}