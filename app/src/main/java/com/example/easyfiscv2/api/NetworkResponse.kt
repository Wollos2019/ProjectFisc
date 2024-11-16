package com.example.easyfiscv2.api

import android.telephony.SmsMessage.MessageClass

sealed class NetworkResponse<out T> {
    data class Success<out T>(val data : T) : NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}