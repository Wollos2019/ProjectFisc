package com.example.easyfiscv2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.easyfiscv2.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM TODO ORDER BY createdAt DESC")
    fun getAllTodo() : LiveData<List<Todo>>

    @Insert
    fun addTodo(todo : Todo)

    @Query("Delete FROM Todo where id = :id")
    fun deleteTodo(id : Int)
}