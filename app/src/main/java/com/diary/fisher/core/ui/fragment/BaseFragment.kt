package com.diary.fisher.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.diary.fisher.core.ui.dialog.LoadAnimationDialogFragment

abstract class BaseFragment : Fragment() {

    private var instanceStateSaved: Boolean = false

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onResume() {
        super.onResume()
        instanceStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        instanceStateSaved = true
    }

    protected fun showProgress(show: Boolean) {
        if (!isAdded || instanceStateSaved) return

        val fragment = childFragmentManager.findFragmentByTag(LoadAnimationDialogFragment.TAG)
        if (fragment != null && !show) {
            (fragment as LoadAnimationDialogFragment).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && show) {
            LoadAnimationDialogFragment().show(
                childFragmentManager,
                LoadAnimationDialogFragment.TAG
            )
            childFragmentManager.executePendingTransactions()
        }
    }
}