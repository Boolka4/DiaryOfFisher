package com.diary.fisher.create_single_line_data.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.diary.fisher.R
import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_single_line_data.presentation.view_model.CreateSingleLineDataViewModel
import kotlinx.android.synthetic.main.dialog_single_line_data.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CreateSingleLineDataDialogFragment : AppCompatDialogFragment() {

    private val viewModel by viewModel<CreateSingleLineDataViewModel> {
        parametersOf(requireArguments().getParcelable<CreateDataType>(ARG_DATA_TYPE))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_single_line_data, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (requireArguments().getParcelable<CreateDataType>(ARG_DATA_TYPE)) {
            CreateDataType.HOOK_BRAND -> {
                dialog!!.setTitle(R.string.create_hook_brand_title)
            }
            CreateDataType.FEED_BOX_BRAND_NAME -> {
                dialog!!.setTitle(R.string.create_feeder_box_brand_title)
            }
        }
        etSingleData.requestFocus()
        isCancelable = false
        dialog?.setCanceledOnTouchOutside(false)

        viewModel.getNavigationLiveData().observe(viewLifecycleOwner, Observer { itemId ->
            findNavController().popBackStack()
            setFragmentResult(requireArguments().getString(ARG_RESULT_KEY)!!, Bundle().apply {
                putLong(ARG_CREATE_DATA_RESULT_ITEM, itemId)
                putLong(ARG_CREATE_DATA_ELEMENT_ID, requireArguments().getLong(ARG_ELEMENT_ID_KEY))
            })
        })

        btnSave.setOnClickListener { viewModel.onSaveDataClicked(etSingleData.text.toString()) }
        btnCancel.setOnClickListener { viewModel.onCancelClicked() }
    }

    companion object {

        const val ARG_CREATE_DATA_ELEMENT_ID = "ARG_CREATE_DATA_ELEMENT_ID"
        const val ARG_CREATE_DATA_RESULT_ITEM = "ARG_CREATE_DATA_RESULT_ITEM"

        private const val ARG_DATA_TYPE = "ARG_DATA_TYPE"
        private const val ARG_RESULT_KEY = "ARG_RESULT_KEY"
        private const val ARG_ELEMENT_ID_KEY = "ARG_ELEMENT_ID_KEY"

        fun getBundle(
            createDataType: CreateDataType,
            resultKey: String,
            elementId: Long
        ): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(ARG_DATA_TYPE, createDataType)
            bundle.putString(ARG_RESULT_KEY, resultKey)
            bundle.putLong(ARG_ELEMENT_ID_KEY, elementId)
            return bundle
        }
    }
}
