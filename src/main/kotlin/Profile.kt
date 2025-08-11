import com.sars.auth.Role
import com.sars.auth.User
import com.sars.connection.DatabaseConnection

class Profile {
    val userList = mutableListOf<User>()

    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/sars",
        "root",
        ""
    )
    val conn = db.getConnection()
    fun profile(user: User){
        println("\n=====PROFILE=====")
        println("name: ${user.name}\nemail: ${user.email}\nrole: ${user.role}")
        print("press any key to continue..")
        readln()
        return
    }
    fun listUsersProfile(){
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
        print("press any key to continue: ")
        readln()
    }
    fun listEmployeeProfile(){
        val stmtAllUser = conn.prepareStatement("SELECT * FROM users where role = ?")
        stmtAllUser.setString(1, "EMPLOYEE")
        val rs = stmtAllUser.executeQuery()
        println("=====LIST USERS=====")
        while (rs.next()){
            val name = rs.getString("name")
            val email = rs.getString("email")
            val role = rs.getString("role")
            userList.add(User(name, email, Role.valueOf(role)))
        }
        userList.forEachIndexed { index, value ->
            println("${index+1}.Name: ${value.name}\nEmail: ${value.email}\n")
        }
        print("press any key to continue: ")
        readln()

    }
}