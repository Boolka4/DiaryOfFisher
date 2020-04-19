package com.diary.fisher.create_single_line_data.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.diary.fisher.R
import com.diary.fisher.core.models.common.SingleLineDataType
import kotlinx.android.synthetic.main.dialog_single_line_data.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreateSingleLineDataDialogFragment : AppCompatDialogFragment() {

    private val viewModel by viewModel<CreateSingleLineDataViewModel>()

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
        etSingleData.requestFocus()
        isCancelable = false
        dialog?.setCanceledOnTouchOutside(false)


        val screenStateObserver = Observer<Boolean> {
            etSingleData.setText("text text text")
            findNavController().popBackStack()
        }

        viewModel.getStateLiveData().observe(viewLifecycleOwner, screenStateObserver)

        btnSave.setOnClickListener { viewModel.onSaveDataClicked(etSingleData.text.toString()) }
        btnCancel.setOnClickListener { viewModel.onCancelClicked() }

    }

    companion object {
        private const val ARG_DATA_TYPE = "ARG_DATA_TYPE"

        fun getBundle(singleLineDataType: SingleLineDataType): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(ARG_DATA_TYPE, singleLineDataType)
            return bundle
        }
    }
}
