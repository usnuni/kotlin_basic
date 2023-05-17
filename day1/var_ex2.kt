package day1

fun main() {
    val a:Any
    a = 4.5465f
    println(a)
    println(a.javaClass.name) // 변수 형식 확인

    val b :Any
    b = 323L
    println(b)
    println(b.javaClass.name)


    val c :Any
    c = true
    println(c)
    println(c.javaClass.name)
    println(c is Boolean) // 이게 맞는지 확인

}