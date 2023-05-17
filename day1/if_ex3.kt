package day1

fun some(bdata:Boolean){
    if(bdata)
        println("진실")
    else
        println("거짓")
}


fun main(){
    val count = 15
    some(if(count > 20) true else false)
}