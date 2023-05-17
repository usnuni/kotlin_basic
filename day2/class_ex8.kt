package day2

class User8{
    var data1:String
    var data2:Int

    init { // 초기화 사용
        data1 = "kim"
        data2 = 10
    }
}

fun main() {
    var user = User8()
    println("data1: ${user.data1}, ${user.data2}")

}