package day2


// 최상위 클래스는 Any가 된다.
//class Shape:Any(){
//    var x:Int = 0
//    var y:Int = 0
//}
//
//
//fun main() {
//    val obj1:Any = Shape()
//    val obj2:Any = Shape()
//
//    println(obj1.equals(obj2))
//}


open class Shape{
    var x:Int = 0
        set(value){
            if(value<0) field = 0
            else field = value
        }
    var y:Int = 0
        set(value){
            if(value<0) field = 0
            else field = value
        }

    lateinit var name:String

    open fun printIfo(){
        println("name: $name, location: $x, $y")
    }
}


// 괄호 있고없고는 생성자 호출? --- 후술
// init 자동으로 명시되는것이 아니기 때문에 명시해줘야한다.

class Rect:Shape(){ // 상속받기
    var width:Int = 0
        set(value){
            if(value<0) field = 0
            else field = value
        }
    var height:Int = 0
        set(value){
            if(value<0) field = 0
            else field = value
        }

    override fun printIfo() { // 오버라이딩
        super.printIfo()
        println("width: $width, height: $height")
    }
}

class Circle:Shape{ // 생성가 호출될 때 ()사용해주지 않았으면 안에서 해줘야 함
    constructor():super()
    var r:Int = 0
        set(value){
            if(value<0) field = 0
            else field = value
        }

    override fun printIfo() {
        super.printIfo()
        println("radius: $r")
    }
}

fun main() {
    var rect = Rect()
    rect.name = "Rect" //초기화 시켜줌
    rect.x = 10
    rect.y = 20
    rect.width = 30
    rect.height = 30
    rect.printIfo()
    println()

    var circle = Circle()
    circle.name = "Circle"
    circle.x = 100
    circle.y = 200
    circle.r = 20
    circle.printIfo()


}