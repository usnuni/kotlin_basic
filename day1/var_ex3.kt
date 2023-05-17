package day1

fun main() {
    var data1:Int? = null // null값을 입력하려면 ?를 붙여줘야함 안 붙이면 에러
    var data2:Int? = null

    println(data1)
    println(data2)

    data1 = 100
    data2 = 200

    println(data1)
    println(data2)

    var data3:Any? = null
    data3 = 2121.325f
    println(data3)
    println("$data3 $data2") //print 여러개 하려면


}