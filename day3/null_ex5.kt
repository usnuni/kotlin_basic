package day3

fun main() {
    var data:String? = "kim"
    // var data:String? = null

    var length:Int = if(data != null){
        data.length
    }else{
        -1  // null이면 -1을 값으로 전달
    }
    println("length: $length")
    println()

    // data가 null이면 값(-1)을 전달해주고, 아니라면 정상적으로 동작
    length = data?.length?:-1
    println("length: $length")
    println()

    val strData:String = "kim"
//    val intdata:Int = strData as Int   // 이걸 사용하면 에러남
    val intdata:Int? = strData as? Int
    println(intdata)

}