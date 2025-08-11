package com.sars.manager

import Profile
import checkFilterList
import com.sars.auth.User

class Manager {
    val listMenuManager = mutableListOf("view employee list", "view profile", "create monthly report", "keluar")
    fun menuManager(user: User){
        while (true) {
            println("\n")
            println("=====MANAGER MENU=====")
            val chooseMenu = checkFilterList("Pilih: ", listMenuManager)
            when (chooseMenu) {
                "view employee list" -> {
                    Profile().listEmployeeProfile()
                    continue
                }
                "view profile" -> {
                    Profile().profile(user)
                    continue
                }
                "create monthly report" -> {
                    continue
                }
                "keluar" -> {
                    return
                }
            }
        }
    }
}