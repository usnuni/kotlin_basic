package day3

class MathUtil<T:Number>{ // Double 사용하기 때문에 숫자만 입력 가능하도록 제한해주어야 한다.
    fun plus(arg1:T, arg2:T):Double{
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun main() {
    val obj1 = MathUtil<Int>()
    println(obj1.plus(100, 200))

    val obj2 = MathUtil<Float>()
    println(obj2.plus(4242.32f, 215.512f))

//     val obj3 = Mathutil<String>() // 이처럼 숫자가 아닌 string 넣으면 컴파일에러 발생.

}