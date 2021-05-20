package com.mcdar.coroutinesexample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mcdar.coroutinesexample.R
import com.mcdar.coroutinesexample.databinding.RowEmployeeBinding
import com.mcdar.coroutinesexample.datasource.models.Employee

class EmployeeRecyclerViewAdapter(
    private val employees: List<Employee>,
    private val itemListener: EmpClickListener
) :
    RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemBinding: RowEmployeeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_employee,
            parent, false
        )
        return EmployeeViewHolder(
            itemBinding,
            itemListener
        )
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        employees.getOrNull(position)?.let {
            holder.binding.employee = it
            holder.binding.executePendingBindings()
        }

    }

    class EmployeeViewHolder(
        val binding: RowEmployeeBinding,
        private val itemListener: EmpClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.rootView.setOnClickListener {
                itemListener.onItemClick(binding.employee!!)
            }

        }
    }

    interface EmpClickListener {
        fun onItemClick(data: Employee)
    }

}