package com.furkan.tfkbcase.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkan.tfkbcase.R
import com.furkan.tfkbcase.base.BaseFragment
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.MainFragmentBinding
import com.furkan.tfkbcase.ui.main.adapter.MainAdapter2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>() {

    private lateinit var viewModel: MainViewModel
    private var start = 1
    private var isLoading = false
    private var texted = ""
    private var fromAdapter = false
    var productList: ArrayList<Result?>? = arrayListOf()
    lateinit var adapter: MainAdapter2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        adapter = MainAdapter2 {
            goDetailPage(it)
        }

        binding?.rycView?.layoutManager = GridLayoutManager(
            requireContext(),
            2,
            RecyclerView.VERTICAL,
            false
        )

        binding?.rycView?.adapter = adapter

        observeData()
        search()


        binding?.rycView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    if (!isLoading) {
                        fromAdapter = true
                        isLoading = true
                        start += 10
                        Log.d("startttttttt", start.toString())
                        viewModel.getData(texted, start, 10)
                    }
                }
            }
        })
    }

    private fun bindRecylerViewData(data: ArrayList<Result?>?) {
        binding?.progress?.visibility = View.INVISIBLE
        binding?.error?.visibility = View.INVISIBLE
        binding?.rycView?.visibility = View.VISIBLE

        if (fromAdapter == true) {
            adapter.set(data as List<Result>)
            adapter.notifyDataSetChanged()
        } else {
            adapter.set(data as List<Result>)
            adapter.notifyDataSetChanged()
        }
    }

    private fun search() {
        binding?.searchBar?.binding?.editTextSearch?.addTextChangedListener { text ->
            texted = text.toString()
            binding?.progress?.visibility = View.VISIBLE
            fromAdapter = false
            productList?.clear()
            start = 1
            if (text?.isEmpty() == true) {
                adapter.set(null)
                binding?.progress?.visibility = View.INVISIBLE
                binding?.error?.text = getString(R.string.emtpy_text)
                binding?.error?.visibility = View.VISIBLE
            } else {
                viewModel.getData(text.toString(), start, 10)
            }
        }
    }

    private fun observeData() {
        viewModel.getData.observe(viewLifecycleOwner, {
            productList?.clear()
            productList?.addAll(it?.data?.results!!)
            bindRecylerViewData(productList)
            isLoading = false
        })
    }


    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding {
        return MainFragmentBinding.inflate(inflater, container, false)
    }

    fun goDetailPage(data: Result) {
        val navController = findNavController(requireActivity(), R.id.main)
        val bundle = Bundle()
        bundle.putSerializable("data", data)
        navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)

    }


}