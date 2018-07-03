package com.example.kbrakai.nextepisode.activities.base

import android.support.v4.app.Fragment
import com.example.kbrakai.nextepisode.R
import io.reactivex.disposables.Disposable

abstract class BaseFragment : Fragment() {

    var disposables = mutableListOf<Disposable>()

    override fun onPause() {
        super.onPause()
        disposables.forEach { if (!it.isDisposed) it.dispose() }
    }

    fun pushFragment(fragment: Fragment, customTag: String? = null, addtobackStack: Boolean = true, addInsteadOfReplacing: Boolean = false, layout : Int = R.id.fragment_frame) {

        val transaction = activity?.supportFragmentManager?.beginTransaction()

        if (addInsteadOfReplacing) {
            transaction?.add(layout, fragment, customTag
                    ?: fragment::class.java.simpleName)
        } else {
            transaction?.replace(layout, fragment, customTag
                    ?: fragment::class.java.simpleName)
        }
        if (addtobackStack) {
            transaction?.addToBackStack(customTag ?: fragment::class.java.simpleName)
        }
        transaction?.commitAllowingStateLoss()
    }
}