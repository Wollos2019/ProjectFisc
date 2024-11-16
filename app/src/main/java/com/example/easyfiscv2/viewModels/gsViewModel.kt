package com.example.easyfiscv2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyfiscv2.Objects.RetrofitClient
import com.example.easyfiscv2.api.Constant
import com.example.easyfiscv2.api.gsRetroClient
import com.example.easyfiscv2.models.DataModelItem
import kotlinx.coroutines.launch

class gsViewModel : ViewModel() {
    private val _Users = MutableLiveData<List<DataModelItem>>()
    val users: LiveData<List<DataModelItem>> get() = _Users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val users = gsRetroClient.gsApiService.getUsers(Constant.appScriptKey, Constant.lib)
                _Users.value = users
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}