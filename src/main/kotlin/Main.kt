import com.sars.auth.Role


var chance = 2
fun main() {
    val toProgram = checkYesOrNo("Masuk ke program SARS? ")
    if (!toProgram){
        println("Terima kasih!")
        return
    } else {
        //start program
        Start().start()
    }

}
fun checkNullOrBlank(text: String): String{
    print(text)
    var input = readln()
    while (input.isBlank()){
        println("error! tolong input dengan benar!")
        print(text)
        input = readln()
    }
    return input.lowercase()
}
fun checkYesOrNo(text: String): Boolean {
    while (true){
        print(text)
        val choice = readln()
        if (!choice.equals("y", true) && !choice.equals("n", true)){
            print("error! tolong input dengan benar!")
            continue
        }
        return choice.equals("y", true)
    }
}
fun <T>checkFilterList(text: String, list: MutableList<T>): String{
    while (true){
        list.forEachIndexed { index, value ->
            println("${index+1}.$value")
        }
        print(text)
        val input = readln().lowercase()
        if (list.any { it == input }){
            return input
        } else {
            println("pilihan tidak ada, coba lagi!")
            continue
        }
    }
}
fun checkEnumForRole(text: String): String{
    val listRole = mutableListOf(Role.ADMIN, Role.EMPLOYEE, Role.MANAGER)
    while (true){
        listRole.forEachIndexed { index, value ->
            println("${index+1}.$value")
        }
        print(text)
        val choice = readln().uppercase()
        if (listRole.any { it.toString() == choice }){
            return choice.uppercase()
        } else {
            println("\nRole tidak tersedia!\n")
            continue
        }



    }
}
fun handle(operation: Operation){
    when(operation){
        is Operation.Success -> {
            println("Success: ${operation.msg}")

        }
        is Operation.Error -> {
            println("Error: ${operation.msg}")

        }
        is Operation.Loading -> {
            println()
            println("Loading: ${operation.msg}")
            repeat(3) {
                Thread.sleep(1000)
                print(".")
            }
        }
        is Operation.LockedAccount -> {
            println("Locked: ${operation.msg}")
        }


    }
}
fun decreaseChance(): Int{
    val chanceMinusOne = chance--
    println("\nkesempatan tersisa: $chanceMinusOne\n")
    return chanceMinusOne
}