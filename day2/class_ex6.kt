package day2

class User6{
    var name:String = "kin"
        set(value){
            field = value
        }
        get(){
            return field.uppercase() //이름 전달을 대문자로, 함수가 호출되었는지 볼 수 있음
        }

    var age:Int = 20
        set(value){
            if(value>0)
                field = value
            else
                field = 0
        }
        get() = field
}


fun main() {
    val obj1 = User6()
    obj1.name = "lee"
    obj1.age = -40
    println("name: ${obj1.name}")
    println("age: ${obj1.age}")

}