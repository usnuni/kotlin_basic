package day2

class User2(name:String, age:Int) {

    var name:String = ""
    var age:Int = 0

    init{
        this.name = name
        this.age = age
    }

    fun printInfo() {
        println("name: ${name}, age: $age")
    }

}



fun main() {
    val obj2 = User2("lim", 40)
    obj2.printInfo()
}