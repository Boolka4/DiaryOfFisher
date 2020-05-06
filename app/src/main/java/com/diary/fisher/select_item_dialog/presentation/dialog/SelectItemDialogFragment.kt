package com.diary.fisher.select_item_dialog.presentation.dialog

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diary.fisher.R
import com.diary.fisher.core.models.common.SelectItemDataType
import com.diary.fisher.core.models.common.SingleLineDataType
import com.diary.fisher.select_item_dialog.presentation.adapter.SelectSingleItemAdapter
import com.diary.fisher.select_item_dialog.presentation.view_model.SelectSingleItemState
import com.diary.fisher.select_item_dialog.presentation.view_model.SelectSingleItemViewModel
import kotlinx.android.synthetic.main.dialog_select_single_item.*
import org.koin.android.viewmodel.ext.android.viewModel

class SelectItemDialogFragment : AppCompatDialogFragment() {

    private val viewModel by viewModel<SelectSingleItemViewModel>()
    private val selectSingleItemAdapter: SelectSingleItemAdapter =
        SelectSingleItemAdapter { viewModel.onItemClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_select_single_item, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (requireArguments().getParcelable<SingleLineDataType>(ARG_DATA_TYPE)) {
            SingleLineDataType.HOOK_BRAND -> {
                dialog!!.setTitle(R.string.create_hook_brand_title)
            }
        }
        rvSingleChoice.adapter = selectSingleItemAdapter
        rvSingleChoice.layoutManager = LinearLayoutManager(view.context)
        val observer = Observer<SelectSingleItemState> {
            when (it) {
                is SelectSingleItemState.ProgressState -> {
                    rvSingleChoice.visibility = View.GONE
//                    showProgress(true)
                }
                is SelectSingleItemState.ShowItemsState -> {
//                    showProgress(false)
                    rvSingleChoice.visibility = View.VISIBLE

                    selectSingleItemAdapter.setItems(it.items)
                }
            }
        }
        viewModel.getStateLiveData().observe(viewLifecycleOwner, observer)

    }

    companion object {
        private const val ARG_DATA_TYPE = "ARG_DATA_TYPE"

        fun getBundle(selectItemDataType: SelectItemDataType): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(ARG_DATA_TYPE, selectItemDataType)
            return bundle
        }
    }
}