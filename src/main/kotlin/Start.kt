import com.sars.auth.Login
import com.sars.auth.Registration

class Start {
    val listAuthMenu = mutableListOf("registrasi", "login")
    fun start(){
        while (true){
            println("=====SARS=====")
            val chooseMenu = checkFilterList("Pilih: ", listAuthMenu)
            when(chooseMenu){
                "registrasi" -> {
                    Registration().registAcc()
                    continue
                }
                "login" -> {
                    Login().loginAcc()
                    break
                }
            }
            break
        }
    }
}