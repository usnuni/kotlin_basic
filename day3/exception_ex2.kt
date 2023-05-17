package day3

import java.lang.Exception

fun some2(arg:Int):Int{
    if(arg>1)
        throw Exception("parameter must be greater than zero")
    else{
        var sum = 0
        for( i in 1 .. arg)
            sum +=i
        return sum
    }
}

fun main() {
    try {
        println(some2(5))
        println()
        println(some2(-2))
    }catch (e:Exception){
        println("execption -> ${e.toString()}")
    }
}