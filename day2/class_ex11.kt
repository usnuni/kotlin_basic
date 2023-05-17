package day2

import java.awt.Color

class Car2{
    var color:String=""
    var speed:Int = 0

    companion object{
        var carCount:Int = 0
        const val MAXSPEED:Int = 200
        const val MINSPEED:Int = 200
        fun currentCarCount():Int{
            return carCount
        }

    }

    constructor(color:String, speed:Int) {
        this.color = color
        this.speed = speed
        carCount ++

    }

    fun upSpeed(value: Int){
        if(speed+value <= MAXSPEED)
            speed = 200
        else
            speed += value
    }
}


fun main() {
    val myCar1:Car2 = Car2("red", 0)
    val myCar2:Car2 = Car2("green", 0)
    val myCar3:Car2 = Car2("blue", 0)

    myCar1.upSpeed(50)
    println("car1 color: ${myCar1.color}, velocity: ${myCar1.speed}")

    myCar2.upSpeed(20)
    println("car2 color: ${myCar2.color}, velocity: ${myCar2.speed}")

    println()

    println("생성된 자동차 수: ${Car2.currentCarCount()}")

    println(Car2.MAXSPEED)
    println(Car2.MINSPEED)

}