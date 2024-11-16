package com.example.easyfiscv2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easyfiscv2.pages.AppScriptPage
import com.example.easyfiscv2.ui.theme.EasyFiscV2Theme
import com.example.easyfiscv2.ui.theme.WeatherPage
import com.example.easyfiscv2.viewModels.AppScriptViewModel


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        val appScriptViewModel = ViewModelProvider(this)[AppScriptViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            EasyFiscV2Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    //WeatherPage(weatherViewModel)
                    //TodoListPage(viewModel = todoViewModel)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "screen_A", builder = {
                        composable("screen_A"){ TodoListPage(viewModel = todoViewModel, navController) }
                        composable("screen_B" + "/{name}"){
                           val name = it.arguments?.getString("name")
                            WeatherPage(viewModel = weatherViewModel, name?:"No Name") }
                        composable("screen_C"){ MainSreen()}
                        composable("screen_D"){ AppScriptPage(viewModel = appScriptViewModel, navController = navController)}
                    } )
                }
            }
        }
    }
}

