package com.group.taskmanager.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


// A home screen for task manager App



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Task Manager")
                }
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)

        ) {
            Row {
                Text(text = "Task 1")
            }
            Row {
                Text(text = "Task 2")
            }
            Row {
                Text(text = "Task 3")
            }
        }

    }
}


