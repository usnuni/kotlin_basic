package day3

interface MyInterface1
interface MyInterface2

class MyHandler1 : MyInterface1, MyInterface2

class MyHandler2 : MyInterface1

class MyClass5<T> where T:MyInterface1, T:MyInterface2

class Myclass5_2<T> where T:MyInterface1

fun main() {
    var obj1 = MyClass5<MyHandler1>()
//    var obj2 = MyClass5<MyHandler2>() // 위 조건 두 개를 모두 충족하고 있어야 사용 가능.

    var obj2 = Myclass5_2<MyHandler2>() // 이렇게 하면 하나만 사용 가능.

    var obj3 = Myclass5_2<MyHandler1>() // Myhandler 번호랑 상관없이 구성이 같으면 된다. 타입 + 개수가 맞으면 됨.

    println(obj3)
}