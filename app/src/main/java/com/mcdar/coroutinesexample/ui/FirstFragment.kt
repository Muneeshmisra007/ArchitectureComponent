package com.mcdar.coroutinesexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcdar.coroutinesexample.R
import com.mcdar.coroutinesexample.databinding.FragmentFirstBinding
import com.mcdar.coroutinesexample.datasource.models.Employee
import com.mcdar.coroutinesexample.viewmodels.EmployeeViewModel


class FirstFragment : Fragment(),
    EmployeeRecyclerViewAdapter.EmpClickListener {

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_first, container, false)
        viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val recyclerView = binding.employeeList
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        viewModel.employees.observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerView.adapter =
                    EmployeeRecyclerViewAdapter(
                        it,
                        this
                    )
            }

        })
        //Fetching employees list
        viewModel.getEmployees()
    }

    override fun onItemClick(data: Employee) {
        val directions =
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                data
            )
        findNavController().navigate(directions)
    }
}

