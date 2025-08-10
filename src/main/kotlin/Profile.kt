import com.sars.auth.User

class Profile {
    fun profile(user: User){
        println("\n=====PROFILE=====")
        println("name: ${user.name}\nemail: ${user.email}\nrole: ${user.role}")
        print("press any key to continue..")
        readln()
        return
    }
}