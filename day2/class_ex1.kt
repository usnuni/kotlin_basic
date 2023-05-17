package day2

class Car{
    var color:String=""
    var speed:Int = 0

    fun upSpeed(value: Int){
        if(speed+value <=0)
            speed = 0
        else
            speed += value
    }

    fun downSpeed(value: Int){
        if(speed-value <=0)
            speed = 0
        else
            speed -= value
    }
}

fun main() {
    val myCar1 = Car()
    myCar1.color = "red"
    myCar1.speed = 0

    val myCar2:Car = Car()
    myCar2.color = "blue"
    myCar2.speed = 0

    myCar1.upSpeed(50)
    println("car1 color: ${myCar1.color}, velocity: ${myCar1.speed}")

    myCar1.downSpeed(18)
    println("car1 color: ${myCar1.color}, velocity: ${myCar1.speed}")
    println("car2 color: ${myCar2.color}, velocity: ${myCar2.speed}")



}
