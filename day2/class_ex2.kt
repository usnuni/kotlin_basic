package day2

class User1{
    var name:String = ""
    var age:Int = 0

    constructor(name:String, age:Int){
        this.name = name
        this.age = age
    }

    fun printInfo() {
        println("name: ${name}, age: $age")
    }
}

fun main() {
    val obj1 = User1("lim", 40)
    obj1.printInfo()
}