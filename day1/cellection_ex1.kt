package day1

fun main(){
    val sdata1 = setOf("kin", "choi", "park")
    println(sdata1)
    println(sdata1.elementAt(0))


    val sdata2 = mutableSetOf<String>("kin", "choi", "park")
    sdata2.add("oh")
    // 얘는 더할 수 있음

    val sdata3 = setOf<Int>(1,2,3,4)
    val sdata4 = setOf<Int>(3,4,5,6)
    println(sdata3.union(sdata4)) //합집합
    println(sdata3.intersect(sdata4)) // 교집합
    println(sdata3.subtract(sdata4)) // 차집합

}