package day1

fun main() {
    print("이름을 입력하세요:")
    val name = readLine()!!
    print("나이를 입력하세요:")
    val age = readLine()!!.toInt()
    print("시작 연봉을 입력하세요:")
    var salary = readLine()!!.toFloat()

    var earnings :Float = 0f

    for(i in age until 65){
        earnings += salary
        salary += (0.05f * salary)
    }
    println("${name}는 총 $"+earnings+"를 벌 것이다.")
} 

