package day1

fun sum(num1:Int, num2:Int):Int{ // return타입 선언해줘야함
    return num1 + num2
}

fun insa(name:String):Unit{
    println("${name}이/가 인사를 합니다.")
}

fun sum2(a:Int, b:Int):Int{
    var sum = 0
    for( i in a .. b)
        sum += i
    return sum
}

fun sum3(a:Int, b:Int):Int{
    var sum = 0
    fun calsum(){
        for( i in a .. b)
            sum += i
    }
    calsum()
    return sum
}

fun main() {
    println(sum(100, 200))
    insa("choi")
    println(sum2(1, 100))
    println(sum3(1,1000))

}