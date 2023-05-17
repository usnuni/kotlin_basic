package day2

// 클래스를 두 개 한 번에 선언
class User3(var name:String, var age:Int)
class User4(var name:String, var age:Int) {

    fun printInfo() {
        println("name: ${name}, age: $age")
    }

}



fun main() {
    val user1 = User3("lee", 10)
    println(user1.name)
    println(user1.age)

    val user2= User4("kim", 32)
    user2.printInfo()
}