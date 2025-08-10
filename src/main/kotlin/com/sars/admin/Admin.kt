package com.sars.admin

import Profile
import  checkFilterList
import com.sars.auth.User

class Admin {
    val listMenuAdmin = mutableListOf("register new account", "view profile", "delete user", "keluar")
    fun menuAdmin(user: User){
        while (true) {
            println("\n")
            println("=====ADMIN MENU=====")
            val chooseMenu = checkFilterList("Pilih: ", listMenuAdmin)
            when (chooseMenu) {
                "register new account" -> {
                    Register().register()
                    continue
                }
                "view profile" -> {
                    Profile().profile(user)
                    continue
                }
//                "delete user" -> {
//                    Delete().delete()
//                    continue
//                }
                "keluar" -> {
                    return
                }
            }
        }
    }
}