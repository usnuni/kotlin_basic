package day1

fun main(){
    var a1 = 2
    when(a1){
        1 -> println("a1 == 1")
        2 -> println("a1 == 2")
        else -> println("a1은 1도 2도 아닙니다")
    }

    println()

    var a2 = "age"
    when(a2){
        "name" -> println("이름은 김가영입나다")
        "age" -> println("나이는 30입니다")
        else -> println("else")
    }

    println()

    var a3 = 40
    when(a3){
        10, 20 -> println("a3 is 10 or 20")
        30, 40 -> println("a3 is 30 or 40")
        else -> println("else")
    }

    println()

    val a4 = 111
    when(a4){
        in 1 .. 10 -> println("1 <= a4 <= 10")
        in 11 .. 150 -> println("11 <= a4 <= 150")
        else ->  println("a > 150")
    }

    println()

    var ldata = listOf("kin", "lee", "park")
    var arr = arrayOf("one","two","three")

    val data = "one"

    when(data){
        in ldata -> println("data in ldata")
        in arr -> println("data in arr")
        else -> println("else")
    }

}