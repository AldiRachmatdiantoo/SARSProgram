fun main() {
    val toProgram = checkYesOrNo("Masuk ke program SARS? ")
    if (!toProgram){
        println("Terima kasih!")
        return
    } else {
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
fun checkFilterList(text: String, list: MutableList<String>): String{
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
