package com.mbmcode.wowplayer.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mbmcode.wowplayer.Dest
import com.mbmcode.wowplayer.ui.common_ui.MyFAB
import com.mbmcode.wowplayer.ui.common_ui.MyTopAppBar
import com.mbmcode.wowplayer.ui.viewmodel.Vm

@Composable
fun PlayerMainScreen(navController: NavHostController) = Scaffold(
    topBar = { MyTopAppBar(Dest.MAIN.title, navController) },
    floatingActionButton = { MyFAB(navController) }
) {
    val modifier = Modifier.padding(it)
    if (Vm.players.size == 0) {
        Text(text = "Oops!!! No data found for any Player", modifier)
    } else {
        LazyColumn(modifier) {
            items(Vm.players.size) { index->
                PlayerCard(index)
            }
        }
    }

}

@Composable
fun PlayerCard(index: Int) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
) {
    val modifier = Modifier.padding(8.dp)
    val player = Vm.players[index]
    Text(text = player.name, modifier = modifier)
    Text(text = player.age, modifier = modifier)
    Text(text = player.height, modifier = modifier)
    Text(text = player.weight, modifier = modifier)
}
