package day2

open class Car3{
    var color:String = ""
    var speed:Int = 0

    open fun upSpeed(value:Int){
        if (speed +value >= 200)
            speed = 200
        else
            speed += value
    }
    fun downSpeed(value:Int){
        if (speed - value <= 0)
            speed = 0
        else
            speed -= value
    }
}

class Truck:Car3{
    var cc:Int = 0
    companion object{
        const val YEAR = 2020
    }

    constructor(cc:Int){
        this.cc = cc
    }

    override fun upSpeed(value: Int) {
        if (speed +value >= 150)
            speed = 150
        else
            speed += value
    }
}

fun main() {
    val truck = Truck(5000)
    truck.color = "gray"
    truck.speed = 0

    truck.upSpeed(50)
    println("car color: ${truck.color}, velocity:${truck.speed}, cc:${truck.cc}")
}







 

