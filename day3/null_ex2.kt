package day3

/*
    null 확인 연산자 ?
    - null 허용으로 선언한 프로퍼티에는 널값을 대입할 수 있다.
    - null 확인 연산자는 null을 안전하게 사용하기 위해 사용한다.
 */

fun main() {
    var data1: String? = "lim"

    // val length:Int = data1.length

    val length1:Int? = if(data1 != null){ // null값이 아니면 값을 출력
        data1.length
    }else{
        null
    }

    println("length: $length1")
    println()

    // 정상 형태이면 값을 출력하고, 그렇지 않으면 null값을 입력 : '?'
    var length2:Int? = data1?.length
    println("length2: $length2")
    println()

    data1 = null
    length2 = data1?.length
    println(length2)
}
