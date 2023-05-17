package day3

// 형식을 두 개 지정해 줄 수 있다.

class Myclass3<T, A>{
    var info:T? = null
    var data:A? = null

    fun printInfo() {
        println("info: $info, data: $data")
    }

    fun myFunc(arg:T):A?{
        println("arg: $arg")
        return data
    }
}

fun main() {
    // 아래 obj1 & 2 는 동일함 (type 지정 방식)
    var obj1:Myclass3<String, Int> = Myclass3()
    obj1.info = "hello"
    obj1.data = 400
    obj1.printInfo()
    println()

    var obj2 = Myclass3<Int, String>()
    obj2.info = 333
    obj2.data = "seoul"
    obj2.printInfo()


    println()
    println(obj1.myFunc("good day"))

}