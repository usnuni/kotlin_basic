package day3

fun main() {
    val arr = arrayOf("hello", null, "lim")
    arr.forEach { //람다식
        if(it != null){
            println("4it, length: ${it.length}")
            println()
        }
    }

    arr.forEach {
        it?.let { // let은 이걸 사용해서 참조가 가능하게 함
            println("$it, length: ${it.length}")
        }
    }
}