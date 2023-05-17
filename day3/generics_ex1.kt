package day3

/*
    generics
    - 데이터의 안전성을 보장하는 데 사용됨
    - 이를 사용해서 strList에 문자열만 들어가도록 설정 가능 (int, double 등 가능)
    - 설정한 타입 외 object가 들어가면 컴파일 에러 발생
    - 사용자 정의 class에서도 사용 가능
 */

class Myclass<T>{ //사용할 때 T 자리에 object type 입력하면 됨
    var info:T? = null
}

fun main() {
    val obj1 = Myclass<String>()
    obj1.info = "hello"
    println("obj1 info: ${obj1.info}")
    println()

    val obj2 = Myclass<Int>()
    obj2.info = 100
    println("obj2 info: ${obj2.info}")

}