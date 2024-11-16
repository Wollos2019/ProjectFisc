package com.example.easyfiscv2.models

data class House(
    val id : String,
    val name : String,
    val houseColors : String,
    val heads : List<HouseHead>
)

data class HouseHead(
    val id : String,
    val firstName : String,
    val lastName : String
)