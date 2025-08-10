package com.sars.admin

import com.sars.connection.DatabaseConnection
import checkNullOrBlank
import checkEnumForRole
import checkYesOrNo

class Register {
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/sars",
        "root",
        ""
    )
    val conn = db.getConnection()

    fun register(){
        while (true) {

            val stmtInsertRegister = conn.prepareStatement(
                "INSERT INTO users (name, password, email, role) VALUES (?,?,?,?)"
            )

            val username = checkNullOrBlank("masukkan username: ")
            val password = checkNullOrBlank("masukkan password: ")
            val email = checkNullOrBlank("masukkan email: ")
            val role = checkEnumForRole("Pilih role: ")

            stmtInsertRegister.setString(1, username)
            stmtInsertRegister.setString(2, password)
            stmtInsertRegister.setString(3, email)
            stmtInsertRegister.setString(4, role)

            val makeSure = checkYesOrNo("registrasi akun? ")
            if (!makeSure) {
                println("Regis ulang...")
                continue
            } else {
                stmtInsertRegister.executeUpdate()
                return
            }


        }
    }
}