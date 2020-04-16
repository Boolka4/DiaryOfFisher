package com.diary.fisher.waters_list.presentation.view

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diary.fisher.R
import com.diary.fisher.core.ui.fragment.BaseFragment
import com.diary.fisher.waters_list.models.WaterViewItem
import com.diary.fisher.waters_list.presentation.adapter.WatersListAdapter
import com.diary.fisher.waters_list.presentation.view_model.WatersListState
import com.diary.fisher.waters_list.presentation.view_model.WatersListViewModel
import kotlinx.android.synthetic.main.fragment_waters_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class WatersListFragment : BaseFragment() {

    private val viewModel by viewModel<WatersListViewModel>()
    private val watersAdapter: WatersListAdapter = WatersListAdapter { viewModel.onItemClicked(it) }

    override fun getLayoutId() = R.layout.fragment_waters_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvWaters.adapter = watersAdapter
        rvWaters.layoutManager = LinearLayoutManager(view.context)
        val observer = Observer<WatersListState> {
            when (it) {
                is WatersListState.ProgressState -> {
                    tvNoWaters.visibility = View.GONE
                    rvWaters.visibility = View.GONE
                    showProgress(true)
                }
                is WatersListState.EmptyDataState -> {
                    tvNoWaters.visibility = View.VISIBLE
                    rvWaters.visibility = View.GONE
                    showProgress(false)
                }

                is WatersListState.ShowItemsState -> {
                    showProgress(false)
                    tvNoWaters.visibility = View.GONE
                    rvWaters.visibility = View.VISIBLE

                    watersAdapter.setItems(it.items)
                }
            }
        }
        viewModel.getWaterLiveData().observe(viewLifecycleOwner, observer)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_waters_list_search, menu)
    }
}