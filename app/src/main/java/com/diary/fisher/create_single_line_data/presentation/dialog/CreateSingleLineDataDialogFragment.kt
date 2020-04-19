package com.diary.fisher.create_single_line_data.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.diary.fisher.R
import com.diary.fisher.core.models.common.SingleLineDataType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.dialog_single_line_data.*

class CreateSingleLineDataDialogFragment() : AppCompatDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_single_line_data, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (arguments!!.getParcelable<SingleLineDataType>(ARG_DATA_TYPE)) {
            SingleLineDataType.HOOK_BRAND -> {
                dialog!!.setTitle(R.string.create_hook_brand_title)
            }
        }
        etSingleData!!.postDelayed({
            view.requestFocus()
            val imm =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }, 400)
        isCancelable = false
        dialog?.setCanceledOnTouchOutside(false)
    }

    companion object {

        const val TAG = "CreateSingleLineDataDialogFragment"

        private const val ARG_DATA_TYPE = "ARG_DATA_TYPE"

        fun getBundle(singleLineDataType: SingleLineDataType): Bundle {

            val bundle = Bundle()
            bundle.putParcelable(ARG_DATA_TYPE,singleLineDataType)
            return bundle
        }
    }
}
