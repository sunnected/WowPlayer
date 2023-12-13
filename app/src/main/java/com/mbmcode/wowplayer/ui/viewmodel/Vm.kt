package com.mbmcode.wowplayer.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mbmcode.wowplayer.data.Player

object Vm: ViewModel() {

    var pName by mutableStateOf("")
    var pAge by mutableStateOf("")
    var pHeight by mutableStateOf("")
    var pWeight by mutableStateOf("")

    var players = mutableStateListOf<Player>()

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun clearField() {
        pName = ""
        pAge = ""
        pHeight = ""
        pWeight = ""
    }

}
