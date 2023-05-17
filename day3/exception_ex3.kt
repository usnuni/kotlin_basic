package day3

import java.lang.Exception

class MyException(msg:String):Exception(msg){
    val errorData:String = "some error Data"
    fun errorFun(){
        println("errorFun call...")
    }
}


fun some3(){
    throw  MyException("MyExecption error!!!")
}

fun main() {
    try {
        some3()
    }catch (e:MyException){
        println("error message -> ${e.toString()}")
        println("errorData: ${e.errorData}")
        e.errorFun()
    } // 에러가 나면 에러 메세지를 띄우고, 에러 함수 호출
}