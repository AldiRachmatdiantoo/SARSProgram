package com.sars.auth

import com.sars.connection.DatabaseConnection
import checkNullOrBlank
import checkYesOrNo

class Registration {
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/db_login",
        "root",
        ""
    )
    val conn = db.getConnection()
    fun registAcc(){
        while (true){
            println("=====REGISTRASI=====")

            //prepare statement
            val stmtInsert = conn.prepareStatement("INSERT INTO users (name, password, email) VALUES (?,?,?)")
            val name = checkNullOrBlank("Masukkan nama: ")
            val password = checkNullOrBlank("Masukkan password: ")
            val email = checkNullOrBlank("Masukkan email: ")

            val makeSure = checkYesOrNo("Buat Akun? ")
            if (!makeSure){
                println("registrasi ulang...")
                continue
            } else {

                //to mysql
                stmtInsert.setString(1, name)
                stmtInsert.setString(2, password)
                stmtInsert.setString(3, email)
                stmtInsert.executeUpdate()
            }
            println("Berhasil membuat akun!")
            print("press any key to continue: ")
            readln()
            return
        }
    }
}