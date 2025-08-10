package com.sars.auth

import com.sars.connection.DatabaseConnection
import checkNullOrBlank
import com.sars.manager.Manager
import handle
import com.sars.admin.Admin
import com.sars.employee.Employee

class Login {
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/sars",
        "root",
        ""
    )
    val conn = db.getConnection()

    fun loginAcc(){
        println("=====LOGIN=====")
        val checkUname = loginCheckUsername()
        val checkPass = loginCheckPassword(checkUname)
        val checkRole = checkRole(checkUname, checkPass)
        val checkEmail =  loginCheckEmail(checkUname, checkPass)
        val user = User(checkUname, checkEmail, checkRole)
        when(user.role){
            Role.ADMIN -> {
                handle(Operation.Loading("menuju interface admin"))
                Admin().menuAdmin(user)
            }
            Role.MANAGER -> {
                handle(Operation.Loading("menuju interface manager"))
                Manager().menuManager()
        }
            Role.EMPLOYEE -> {
                handle(Operation.Loading("menuju interface employee"))
                Employee().menuEmployee()
            }
        }
        return
    }

    fun loginCheckUsername(): String {
        while (true) {
            println()
            val name = checkNullOrBlank("Masukkan nama: ")
            val stmtSelectName = conn.prepareStatement("SELECT * FROM users WHERE name = ?")
            stmtSelectName.setString(1, name)
            val rs = stmtSelectName.executeQuery()
            if (rs.next()) {
                handle(Operation.Success("berhasil memasukkan username"))
                return name
            } else {
                handle(Operation.Error("username salah!"))
                continue
            }
        }
    }

    fun loginCheckPassword(username: String): String{
        while (true){
            println()
            print("Masukkan password: ")
            val password = readln()
            val stmtSelectPassword = conn.prepareStatement("SELECT * FROM users WHERE name = ?")
            stmtSelectPassword.setString(1, username)
            val rs = stmtSelectPassword.executeQuery()
            if (rs.next()){
                val passwordDb = rs.getString("password")
                if (passwordDb == password){
                    handle(Operation.Success("berhasil memasukkan password"))
                    return password
                }
            } else {
                handle(Operation.Error("Password salah"))
                continue
            }


        }
    }
    fun checkRole(username: String, password: String): Role{
        while (true) {
            println()
            val stmtSelectRole = conn.prepareStatement("SELECT role FROM users WHERE name = ? and password = ?")
            stmtSelectRole.setString(1, username)
            stmtSelectRole.setString(2, password)
            val rs = stmtSelectRole.executeQuery()
            if (rs.next()) {
                val dataUserRole = rs.getString("role")
                val roleStringToEnum = Role.valueOf(dataUserRole.uppercase())
                return roleStringToEnum
            } else {
                handle(Operation.Error("Pilihan Tidak Tersedia!"))
                continue
            }
        }
    }
    fun loginCheckEmail(username: String, password: String): String{
        while (true) {
            println()
            val stmtSelectEmail = conn.prepareStatement("SELECT email FROM users WHERE NAME = ? AND password = ?")
            stmtSelectEmail.setString(1, username)
            stmtSelectEmail.setString(2, password)
            val rs = stmtSelectEmail.executeQuery()
            if (rs.next()){
                val email = rs.getString("email")
                return email
            } else {
                handle(Operation.Error("Email Salah!"))
                continue
            }
        }
    }

}