package day1

fun main(){

    var data1 = 1
    val result = when(data1){
        1 -> "1..."
        2 -> "2..."
        else -> {
            println("else")
            "hello"
        }
    }
    println(result)
}