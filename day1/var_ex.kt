package day1

val str1:String = "Hello"
val str2:String = """
    안녕하세요
    good day
"""
        //.trimIndent()

var str3:String = "Hello"


fun main() {
    println(str1)
    println(str2)
    println(str2)

    str3 = str3 + "world"
    println(str3)
    println("string value:"+str3)
    println("string value:$str3")
    //format 처럼 $를 이용해서 참조 가능

    println(str3[1])
    println("string value:$str3[1]")
    println("string value:${str3[1]}")
    // 구간 안을 변수로 취급하려면

}