package day3

class Adress{
    val city:String = "seoul"
}

class User1{
//    val adress:Adress = Adress()
    val adress:Adress? = null // 이렇게 사용하면 에러남
}

fun main() {
    val user:User1 = User1()
    println(user.adress?.city) // 위 에러를 방지하기 위해 '?' 넣어줌
    println()

    val user2:User1? = null // 여기서 null값 입력해서 이걸 받으려고 밑에서 user2? 한 것 같음
    println(user2?.adress?.city) // user는 왜..
}