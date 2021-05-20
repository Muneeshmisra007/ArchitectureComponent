package com.mcdar.coroutinesexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcdar.coroutinesexample.datasource.RemoteDataSource
import com.mcdar.coroutinesexample.datasource.models.Employee
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmployeeViewModel : ViewModel() {
    private val _employees = MutableLiveData<List<Employee>>()
    val employees: LiveData<List<Employee>>
        get() = _employees
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    
    fun getEmployees() {
        _isLoading.value = true
        viewModelScope.launch {
            withContext(IO) {
                _employees.postValue(RemoteDataSource.getEmployees())
                _isLoading.postValue(false)
            }
        }
    }
}