package day3

class Myclass2<T>(no:T){
    var info:T? = null
}

fun main() {
    val obj1 = Myclass2(10) // 여기에 int값이 들어가서 아래도 동일하게 int값만을 받을 수 있음
//    val obj1 = Myclass2<Int>(10) // 좀 더 확실하게 해주려면 앞에서 <>에 한 번 더 선언해주는데, ()안의 형식과 동일해야 한다.
    obj1.info = 200
    println("obj1 info: ${obj1.info}")
    println()

    val obj2 = Myclass2("hello") //여기는 문자
    obj2.info = "world"
    println("obj2 info: ${obj2.info}")

}