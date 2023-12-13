package com.mbmcode.wowplayer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mbmcode.wowplayer.Dest
import com.mbmcode.wowplayer.data.Player
import com.mbmcode.wowplayer.ui.common_ui.MyTopAppBar
import com.mbmcode.wowplayer.ui.viewmodel.Vm

@Composable
fun AddPlayerScreen(navController: NavHostController) = Scaffold(
    topBar = { MyTopAppBar(Dest.ADD.title, navController, Dest.ADD) },
) {paddingValues ->
    val modifier = Modifier.padding(paddingValues)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        TextField(
            value = Vm.pName,
            onValueChange = { Vm.pName = it },
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            label = { Text(text = "Enter player name")}
        )
        TextField(
            value = Vm.pAge,
            onValueChange = { Vm.pAge = it },
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            label = { Text(text = "Enter player age")}
        )
        TextField(
            value = Vm.pHeight.toString(),
            onValueChange = { Vm.pHeight = it },
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            label = { Text(text = "Enter player height")}
        )
        TextField(
            value = Vm.pWeight.toString(),
            onValueChange = { Vm.pWeight = it },
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            label = { Text(text = "Enter player weight")}
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(48.dp)
                .fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = {navController.navigate(Dest.MAIN.name)},
            ) {
                Text(text = "Cancel")
            }
            OutlinedButton(
                onClick = {
                    Vm.run {
                        if (pName !="" && pAge !="" && pHeight !="" && pWeight !="") {
                            addPlayer( Player(pName, pAge, pHeight, pWeight) )
                            clearField()
                            navController.popBackStack()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = "Save")
            }
        }

    }
}