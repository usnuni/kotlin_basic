package day2

class User7(name:String){
    var myName:String = name
        set(value){
            field = "hi!" + value
        }
        get() = field.uppercase()
}


fun main() {
    val user1 = User7("choi")
    println(user1.myName)
    user1.myName = "lee"
    println(user1.myName)

}