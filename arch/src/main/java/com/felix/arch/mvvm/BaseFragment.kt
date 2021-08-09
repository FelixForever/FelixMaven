package com.felix.lib_arch.mvvm

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import androidx.fragment.app.Fragment
import com.felix.arch.mvvm.IBackable
import com.felix.utils.utils.ITAG
import com.felix.utils.widget.dialog.IInfoDialog
import com.felix.utils.widget.dialog.ILoadDialog

open class BaseFragment : Fragment(), ILoadDialog, IInfoDialog, IBackable,
    ITAG {
    override var ctx: Context? = null
        get() = context
    override var progressDialog: ProgressDialog? = null
    override var infoDialog: AlertDialog? = null
    override fun onDestroyView() {
        super.onDestroyView()
        dismissLoading()
        dismissInfo()
    }

    override fun onBackPress(): Boolean {
        childFragmentManager.fragments?.filter {
            it?.let {
                it.isAdded && it.isMenuVisible && !it.isHidden && it is IBackable
            } ?: false
        }?.map { it as IBackable }.forEach {
            if (it.onBackPress()) {
                return true
            }
        }
        return false
    }
}