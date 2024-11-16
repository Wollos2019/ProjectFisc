package com.example.easyfiscv2.models

data class Operation(
    val id: Int? = null,
    val designation: String? = null,
    val nomination: String? = null,
    //val email: String? = null,
    val address : Address? = null,
    val phone: String? = null,
    val amount: Int? = null
)