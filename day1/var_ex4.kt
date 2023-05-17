package day1

fun main(){

    val myval1:Any = 10
    val myval2:Any? = myval1

    println(myval1)
    println(myval2)

    val myval3:Any? = 20

//  val myval4:Any = myval3
    //이건 에러가 난다 null을 허용하는 변수끼리 사용해야 가능

    //허용하게 하려면
    val myval4:Any = myval3 as Any

    println(myval3)
    println(myval4)

    //허용하는 또 다른 방법
    var data = "good day"
    println(data!!.split(" ")) //쪼개기 기준을 띄어쓰기라고
// 알려줌
    //split를 사용하는 데이터가 null이 아니라는 것을 !!를 통해 알려줌


}