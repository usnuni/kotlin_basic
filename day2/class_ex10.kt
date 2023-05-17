package day2

class User10{
    lateinit var lateData:String //나중에 init
}

fun main() {
    val user = User10()
    user.lateData = "hi everyone"
    println(user.lateData)
}


/*
 1. lateInit은 var을 선언한 프로퍼티에서만 사용할 수 있다.
 2. lateInit은 클래스 몸체에 선얺나 프로퍼티에서만 사용할 수 있다.(주 생성자에선느 사용할 수 없음)
 3. null 서용 프로퍼티는 사용할 수 없다.
 4. 기초타입에 해당하는 프로퍼티는 사용할 수 없다.
 */