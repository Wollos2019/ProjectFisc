package com.example.easyfiscv2.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.easyfiscv2.R
import com.example.easyfiscv2.Todo
import com.example.easyfiscv2.TodoViewModel
import com.example.easyfiscv2.models.DataModelItem

import com.example.easyfiscv2.viewModels.AppScriptViewModel
import com.example.easyfiscv2.viewModels.gsViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppScriptPage(viewModel: TodoViewModel, navController : NavController) {
    val todoList = viewModel.todoList.observeAsState()

    //val dataContacts = viewModel.users.observeAsState()
    //val dataList = data.value

    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText, onValueChange = {
                    inputText = it
                },
                label = {
                    Text(text = "Add a Todo Item")
                })
            Column {
                Button(onClick = {
                    viewModel.fetchUsers()
                    inputText = ""
                }) {
                    Text(text = "Add")
                }
                Button(onClick = {
                    navController.navigate("screen_B" + "/John")
                }) {
                    Text(text = "Weather")
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Button(onClick = {
                    navController.navigate("screen_D")
                }) {
                    Text(text = "AppScript")
                }
            }
        }

        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { index: Int,
                                       item: DataModelItem ->
                        com.example.easyfiscv2.ContactItem(item = item,
                            onDelete = {
                                viewModel.deleteData(item.id)
                            })
                    }
                }
            )
        }?: Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = "No items yet",
        fontSize = 16.sp)
    }
}

@Composable
fun ContactItem(item : DataModelItem, onDelete : ()-> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (modifier = Modifier.weight(1f)) {
            Text(text = item.lastname,
                fontSize = 10.sp,
                color = Color.LightGray)
            Text(text = item.firstname,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        IconButton(onClick = onDelete) {
            Icon(painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White)
        }
    }
}