package com.sars.auth

import com.sars.connection.DatabaseConnection
import checkNullOrBlank

class Login {
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/db_login",
        "root",
        ""
    )
    val conn = db.getConnection()

    fun loginAcc(){
        println("=====LOGIN=====")
        loginCheckPassword(loginCheckUsername())
        println("gacor")
    }
    fun loginCheckUsername(): String {
        while (true) {
            val name = checkNullOrBlank("Masukkan nama: ")
            val stmtSelectName = conn.prepareStatement("SELECT * FROM users WHERE name = ?")
            stmtSelectName.setString(1, name)
            val rs = stmtSelectName.executeQuery()
            if (rs.next()) {
                println("Berhasil Menemukan username $name!")
                return name
            } else {
                println("Nama tidak ditemukan! coba lagi..!")
                continue
            }
        }
    }
    fun loginCheckPassword(username: String){
        while (true){
            val password = checkNullOrBlank("Masukkan password: ")
            val stmtSelectPassword = conn.prepareStatement("SELECT password FROM users WHERE name = ?")
            stmtSelectPassword.setString(1, username)
            val rs = stmtSelectPassword.executeQuery()
            if (rs.next()){
                val passwordDb = rs.getString("password")
                if (passwordDb == password){
                    println("Password Berhasil!")
                    return
                }
            } else {
                println("Password salah")
                continue
            }
        }
    }

}