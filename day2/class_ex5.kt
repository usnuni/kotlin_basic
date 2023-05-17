package day2

class User5 {
    var name: String = ""
    var age: Int = 0

    constructor() {
        this.name = "kim"
        this.age = 10
    }

    constructor(name:String){
        this.name = name
        this.age = 10
    }

    constructor(age:Int){
        this.name = "kim"
        this.age = age
    }
    constructor(name:String, age:Int){
        this.name = name
        this.age = age
    }

    fun printInfo() {
        println("name: $name, age: $age")
    }
}

fun main() {
    val obj1 = User5()
    val obj2 = User5(name = "lim")
    val obj3 = User5 (age = 20)
    val obj4 = User5(name = "choi", age = 40)

    obj1.printInfo()
    obj2.printInfo()
    obj3.printInfo()
    obj4.printInfo()
}
