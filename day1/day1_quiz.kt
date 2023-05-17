package day1

/*
1. 노동자들이 65세에 퇴직하기 전에 얼마나 많은 돈을 벌 수 있는 지 추정하라.
    노동자의 이름, 나이, 돈을 벌기 시작하는 시점은 입력값으로 받는다.
    노동자는 매년 5%의 연봉 인상액을 받는다고 가정한다.

    sol)
    이름 : kim, 나이: 25, 시작 연봉: 20000
    kim은 총 $2415995.0를 벌 것이다.
 */

//fun main() {
//
//    print("이름을 입력하세요:")
//    val name = readLine()!!
//    print("나이를 입력하세요:")
//    val age = readLine()!!.toInt()
//    print("시작 연봉을 입력하세요:")
//    var salary = readLine()!!.toFloat()
//
//    var earning:Float = 0f
//
//    for(i in age until 65){
//        earning += salary
//        salary += (0.05f * salary)
//    }
//
//    println("${name}은/는 총 $"+earning+"을 벌 것이다.")
//
//}

/*
2. 여러분이 10일 작업에 대한 두 가지 급여 옵션을 제의 받았다고 가정하자.

    옵션1: 하루에 $100 지급
    옵션2: 첫째날에 $1, 둘째 날에 $2, 셋째 날에 $4 등 매일 전일 급여의 두 배를 받음

    두 가지 옵션 중에 어던 경우가 좀 더 유리한 옵션인지 결정하라.
    이 때 Option1과 Option2라는 함수를 각각 생성하여 계산하라.
 */

fun option1():Int{
    var sum:Int = 0
    for(i in 1 .. 10)
        sum += 100
    return sum
}

fun option2():Int{
    var sum:Int = 0
    var datsalay:Int = 1
    for(i in 1 .. 10){
        sum += datsalay
        datsalay *= 2
    }
    return sum
}

fun main() {
    val opt1 = option1()
    val opt2 = option2()
    print("option1 = $opt1")
    print("option2 = $opt2")

    if(opt1>opt2)
        println("option1 pays betters")
    if(opt1==opt2)
        print("same")
    else
        println("option2 pays betters")


}