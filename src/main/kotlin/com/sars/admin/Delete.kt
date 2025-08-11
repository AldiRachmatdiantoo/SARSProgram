package com.sars.admin
import com.sars.auth.User
import com.sars.connection.DatabaseConnection
import com.sars.auth.Role
import handle
import checkNullOrBlank

class Delete {
    val userList = mutableListOf<User>()
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/sars",
        "root",
        ""
    )
    val conn = db.getConnection()
    fun delete(user: User){
        val check = checkPasswordAdmin(user)
        if (!check){
            return
        } else {
            listToDelete()
            return
        }

    }

    fun checkPasswordAdmin(user: User): Boolean {
            val stmtPassword = conn.prepareStatement("SELECT password FROM users WHERE name = ?")
            stmtPassword.setString(1, user.name)


            print("masukkan password: ")
            val passwordInput = readln()
            val rs = stmtPassword.executeQuery()
            if (rs.next()){
                val passUser = rs.getString("password")
                if (passwordInput != passUser){
                    handle(Operation.Error("password salah"))
                    return  false
                }
        }
        return true
    }
    fun listToDelete(){
        val stmtAllUser = conn.prepareStatement("SELECT * FROM users")
        val rs = stmtAllUser.executeQuery()
        println("=====LIST USERS=====")
        while (rs.next()){
            val name = rs.getString("name")
            val email = rs.getString("email")
            val role = rs.getString("role")
            userList.add(User(name, email, Role.valueOf(role)))
        }
        userList.forEachIndexed { index, value ->
            println("${index+1}.Name: ${value.name}\nEmail: ${value.email}\nRole: ${value.role}\n")
        }
        val chooseDelete = checkNullOrBlank("siapa yang ingin anda hapus? ")
        val checks = checkUserIfTrue(chooseDelete)
        if (!checks){
            handle(Operation.Error("User Tidak Ada!"))
            return
        } else {
            toDelete(chooseDelete)
        }
        conn.close()
        stmtAllUser.close()
    }
    fun checkUserIfTrue(chooseDelete: String): Boolean{
        val stmtSelectUser = conn.prepareStatement(
            "SELECT * FROM users where name = ?"
        )
        stmtSelectUser.setString(1, chooseDelete)
        val rs = stmtSelectUser.executeQuery()
        if (rs.next()){
            val userDb = rs.getString("name")
            return userDb == chooseDelete
        }
        conn.close()
        stmtSelectUser.close()
        return false

    }
    fun toDelete(chooseDelete: String){
        val stmtExecuteDelete = conn.prepareStatement("DELETE FROM users WHERE name = ?")
        stmtExecuteDelete.setString(1, chooseDelete)
        stmtExecuteDelete.executeUpdate()
        handle(Operation.Success("berhasil menghapus $chooseDelete!"))

        conn.close()
        stmtExecuteDelete.close()
    }
}