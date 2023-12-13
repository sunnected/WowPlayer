package com.mbmcode.wowplayer.ui.common_ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mbmcode.wowplayer.Dest


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, navController: NavHostController, dest: Dest = Dest.MAIN) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = { if (dest == Dest.ADD) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        }  },
        actions = {},
        modifier = Modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    )
}

@Composable
fun MyFAB(navController: NavHostController) = FloatingActionButton(
    onClick = { navController.navigate(Dest.ADD.name) },
) {
    Icon(
        imageVector = Icons.Filled.Add,
        contentDescription = "Add Player"
    )
}