package com.diary.fisher.core.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.diary.fisher.R

class LoadAnimationDialogFragment  : AppCompatDialogFragment() {

    override fun getTheme(): Int = R.style.TransparentDialogTheme

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_progress_dialog, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isCancelable = false
        dialog?.setCanceledOnTouchOutside(false)
    }

    companion object {
        const val TAG = "LoadAnimationDialogFragment"
    }
}