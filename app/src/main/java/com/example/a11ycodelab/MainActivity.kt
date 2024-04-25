package com.example.a11ycodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.a11ycodelab.ui.theme.Purple40

const val ROUTE_BASIC = "Basic"
const val ROUTE_CUSTOM_ACTIONS = "CustomActions"
const val ROUTE_MERGE = "Merge"
const val ROUTE_HEADINGS = "Headings"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Purple40)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "A11y Codelab",
                            color = Color.White,
                            fontSize = 24.sp,
                        )
                    }
                },
                bottomBar = {
                    BottomBar(
                        listOf(
                            ROUTE_BASIC,
                            ROUTE_CUSTOM_ACTIONS,
                            ROUTE_MERGE,
                            ROUTE_HEADINGS
                        )
                    ) {
                        if (it != navController.currentDestination?.route) {
                            navController.navigate(it)
                        }
                    }
                }
            ) {
                NavHost(
                    modifier = Modifier.padding(it),
                    navController = navController,
                    startDestination = "HOME"
                ) {
                    navigation(startDestination = ROUTE_BASIC, route = "HOME") {
                        composable(ROUTE_BASIC) {
                            Basic()
                        }
                        composable(ROUTE_CUSTOM_ACTIONS) {
                            CustomActions()
                        }
                        composable(ROUTE_MERGE) {
                            Merge()
                        }
                        composable(ROUTE_HEADINGS) {
                            Heading()
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun BottomBar(routerList: List<String>, onClick: (String) -> Unit) {
    var selectedRoute by remember { mutableStateOf(routerList.first()) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple40)
            .padding(vertical = 8.dp)
    ) {
        routerList.forEach {
            val isSelected = selectedRoute == it
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable {
                        selectedRoute = it
                        onClick(it)
                    }
            ) {
                Icon(
                    imageVector = when (it) {
                        ROUTE_BASIC -> Icons.Default.Home
                        ROUTE_CUSTOM_ACTIONS -> Icons.Default.Favorite
                        ROUTE_MERGE -> Icons.Default.Build
                        ROUTE_HEADINGS -> Icons.Default.List
                        else -> Icons.Default.Home
                    },
                    contentDescription = null,
                    tint = if (isSelected) Color.White else Color.Unspecified
                )

                Text(
                    it,
                    fontSize = 16.sp,
                    color = if (isSelected) Color.White else Color.Unspecified,
                )
            }
        }
    }
}
