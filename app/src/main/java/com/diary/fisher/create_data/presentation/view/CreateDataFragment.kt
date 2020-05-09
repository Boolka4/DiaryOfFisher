package com.diary.fisher.create_data.presentation.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diary.fisher.R
import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.models.common.SelectItemDataType
import com.diary.fisher.core.models.common.SingleLineDataType
import com.diary.fisher.core.ui.fragment.BaseFragment
import com.diary.fisher.create_data.presentation.adapter.CreateDataAdapter
import com.diary.fisher.create_data.presentation.view_model.CreateDataState
import com.diary.fisher.create_data.presentation.view_model.CreateDataViewModel
import com.diary.fisher.create_single_line_data.presentation.dialog.CreateSingleLineDataDialogFragment
import kotlinx.android.synthetic.main.fragment_create_data.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CreateDataFragment : BaseFragment() {

    private val viewModel by viewModel<CreateDataViewModel> {
        parametersOf(requireArguments().getParcelable<CreateDataType>(ARG_DATA_TYPE))
    }
    private val createDataAdapter: CreateDataAdapter =
        CreateDataAdapter { viewModel.onItemClicked(it) }

    override fun getLayoutId() = R.layout.fragment_create_data

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCreateData.adapter = createDataAdapter
        rvCreateData.layoutManager = LinearLayoutManager(view.context)
        val screenStateObserver = Observer<CreateDataState> {
            when (it) {
                is CreateDataState.ProgressState -> {
                    rvCreateData.visibility = View.GONE
                    showProgress(true)
                }
                is CreateDataState.ShowItemsState -> {
                    showProgress(false)
                    rvCreateData.visibility = View.VISIBLE

                    createDataAdapter.setItems(it.items)
                }
            }
        }

        viewModel.getReportsLiveData().observe(viewLifecycleOwner, screenStateObserver)
        btnSaveData.setOnClickListener { viewModel.onSaveDataClicked() }
    }

    companion object {
        private const val ARG_DATA_TYPE = "ARG_DATA_TYPE"

        fun getBundle(createDataType: CreateDataType): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(ARG_DATA_TYPE, createDataType)
            return bundle
        }
    }
}