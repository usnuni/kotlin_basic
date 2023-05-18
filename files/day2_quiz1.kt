package day2

class Wages{
    var name:String = ""
        set(value){
            field = value
        }
        get() = field

    var hours:Double = 0.0
        set(value){
            field = value
        }
        get() = field

    var wage:Double = 0.0
        set(value){
            field = value
        }
        get() = field

    fun payForWeek():Double{
        var amount:Double = this.hours * this.wage
        if (this.hours > 40){
            amount = 40 * this.wage + ((this.hours -40) * (1.5 * this.wage))
        }
        return amount
    }
}

fun main() {
    val salary = Wages()
    print("Enter person's name:")
    val name = readLine()!!
    salary.name = name
    print("Enter number of hours worked: ")
    val hours:Double = readLine()!!.toDouble()
    salary.hours = hours
    print("Enter hourly wage: ")
    val wage:Double = readLine()!!.toDouble()
    salary.wage = wage

    println("Pay for ${salary.name} : $${salary.payForWeek()}")

}
 

