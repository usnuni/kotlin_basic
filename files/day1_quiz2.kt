package day1

fun option1():Int{
    var sum : Int = 0
    for(i in 1..10)
        sum += 100
    return sum
}

fun option2():Int{
    var sum : Int = 0
    var daySalay:Int = 1
    for(i in 1..10) {
        sum += daySalay
        daySalay *= 2
    }
    return sum
}

fun main() {
    val opt1 = option1()
    val opt2 = option2()
    println("option1=$opt1")
    println("option2=$opt2")

    if(opt1 > opt2)
        println("option1 pays betters")
    else if(opt1 == opt2)
        println("options pay the same")
    else
        println("option2 pays betters")
} 

