package day1

fun main(){
    val a = 12
    val result:String

    if(a>10)
        result = "hello"
    else
        result = "world"

    println(result)

    /*
    result = if(a>10) "hello" else "world"
    println(result)
     */

    var result2 = if(a>10){
        println("hello")
        10 + 20
    }else{
        println("world")
        20 * 4
    }

    println(result2)


    var b =22
    var result3 = if(b<10)20
    else if(b<20)30
    else 40

    println(result3)


}