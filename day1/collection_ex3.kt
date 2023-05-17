package day1

fun main() {
    val data1 = listOf<String>("hello", "world")
    val iter1 = data1.iterator()

    println(iter1)

    while(iter1.hasNext()) // 뒤가 비어있지 않다면..~
        println(iter1.next())

    println()

    val mdata1 = mapOf<String, Any>("name" to "kim", "height" to 180)
    val iter2 = mdata1.iterator()
    while(iter2.hasNext()){
        val data = iter2.next()
        println(data)
        println("key:${data.key} value:${data.value}\n")
    }

}
