package com.diary.fisher.waters_list.presentation.view

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import com.diary.fisher.R
import com.diary.fisher.core.ui.fragment.BaseFragment
import com.diary.fisher.waters_list.presentation.adapter.WatersListAdapter
import com.diary.fisher.waters_list.presentation.view_model.WatersListState
import com.diary.fisher.waters_list.presentation.view_model.WatersListViewModel
import kotlinx.android.synthetic.main.fragment_waters_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class WatersListFragment : BaseFragment() {


    private val viewModel by viewModel<WatersListViewModel>()
    private val watersAdapter: WatersListAdapter = WatersListAdapter { viewModel.onItemClicked(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_waters_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvWaters.adapter = watersAdapter

        val observer = Observer<WatersListState> {
            when (it) {
                is WatersListState.ProgressState -> {
                    tvNoWaters.visibility = View.GONE
                    rvWaters.visibility = View.GONE
                    showProgress(true)
                }
                is WatersListState.EmptyDateState -> {
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
        viewModel.state.observe(viewLifecycleOwner, observer)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_waters_list_search, menu)
    }
}