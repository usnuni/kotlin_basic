package day3

import java.lang.Exception

fun some1(arg:String):Int{
    val parseData:Int = try{
        arg.toInt()
    }catch(e:Exception){
        println("${e.toString()}")
        0
    }finally {
        println("finally")
    }
    return parseData
}

fun main() {
    println("result: ${some1("200")}")
    println()
    println("result2: ${some1("kim")}")
}
