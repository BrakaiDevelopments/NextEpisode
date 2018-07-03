package com.example.brakai.nextepisode.helpers

import android.app.Activity
import android.content.Context
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.inputmethod.InputMethodManager

object ViewHelper {

    fun dismissDialogFragment(dialog: DialogFragment?) {
        try {
            if (dialog != null && dialog.isAdded) {
                dialog.dismissAllowingStateLoss()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun showDialogFragment(manager: FragmentManager?, dialog: DialogFragment?, tag: String?) {
        if (dialog != null && tag != null) {
            dismissDialogFragment(dialog)
            try {
                if (manager != null) {
                    val fragment = manager.findFragmentByTag(tag)
                    if (fragment == null && !dialog.isAdded && !dialog.isVisible && (dialog.dialog == null || !dialog.dialog.isShowing)) {
                        dialog.show(manager, tag)
                    } else {
                        if (fragment != null) {
                            dismissDialogFragment(fragment as DialogFragment)
                        }
                        dismissDialogFragment(dialog)
                        dialog.show(manager, tag)
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

        }
    }

    fun closeKeyboard(activity: Activity?) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        if (activity != null && imm != null && imm.isActive && activity.currentFocus != null)
            imm.hideSoftInputFromWindow(activity.currentFocus.windowToken, 0)
    }
}