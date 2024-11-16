package com.example.easyfiscv2.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyfiscv2.Todo

import com.example.easyfiscv2.api.AppScriptInstance
import com.example.easyfiscv2.api.Constant

import com.example.easyfiscv2.api.NetworkResponse
import com.example.easyfiscv2.api.NetworkResponse.*
import com.example.easyfiscv2.models.DataModel
import com.example.easyfiscv2.models.DataModelItem

import com.example.easyfiscv2.models.Operation
import kotlinx.coroutines.launch

class AppScriptViewModel : ViewModel() {
    private val appScriptApi = AppScriptInstance.appScriptApi
    private val _appScriptResult = MutableLiveData<NetworkResponse<DataModel>>()
    val appScriptResult : LiveData<NetworkResponse<DataModel>> = _appScriptResult
    private val _dataList = MutableLiveData<List<DataModelItem>>()
    val dataList : LiveData<List<DataModelItem>>get () = _dataList
    //val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()

    fun getData() {
        _appScriptResult.value = Loading
        viewModelScope.launch {

            try {
                val response = appScriptApi.getClients(Constant.appScriptKey, Constant.lib)
                //val response = appScriptApi.getClients()
                Log.i("Error : ",response.message())

                if (response.isSuccessful){
                    //dataList = response.body()?.content ?: listOf<DataModelItem>()
                    //_dataList = response.body()?.listIterator()
                    response.body() ?.let {
                        _appScriptResult.value = Success(it)
                    }
                } else {
                    Log.i("Error : ", response.message())
                    _appScriptResult.value = Error("Failed to load Data No exception")
                }
            } catch (e : Exception) {
                Log.i("Error : ", e.toString())
                _appScriptResult.value = Error("Failed to load Data")

            }
        }
    }

    fun deleteData(Id : Int){}
}