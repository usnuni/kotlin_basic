package day3

/*
    null 안정성
    - null이란 아무것도 입력되지 않은 상태.
 */

var data1:String = "lim"
var data2:String? = null

fun main() {
    data2 = "hello"

    //case1
    val data3:String = data2!!
    println("data3: $data3")
    // null값을 받을 수 있도록 ?를 붙여줘야 하는데 없으면 에러 발생
    // OR NULL이 아니라고 !! 붙여서 확실하게 알려줘야 한다.

    // case2
    val data4:String? = data2
    println("data4: $data4")
    // 이처럼 데이터로 null값을 동일하게 받을 수 있도록 설정해주기
}