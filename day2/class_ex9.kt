package day2

class User9{
    val name1:String = "lim"
    var name2:String? = null
    var age:Int? = null

    constructor(name2:String, age:Int){
        this.name2 = name2
        this.age = age
    }

    fun printInfo(){
        println("name1: ${name1}, name2: ${name2}, age: $age")
    }

}

fun main() {
    val user = User9("lee", 30)
    user.printInfo()
}