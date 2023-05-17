package day1

fun main(){
    var data1 = Array<Int>(3, {0})
    println(data1[0])
    println(data1[1])
    println(data1[2])

    data1[0] = 10
    data1[1] = 20
    data1[2] = 30

    println(data1[0])
    println(data1[1])
    println(data1[2])
    println()

    var data2 = Array<Int>(3, {i -> (i+1) * 100}) // lamda식 사용
    println(data2[0])
    println(data2[1])
    println(data2[2])
    println()


    var data3 = intArrayOf(4,5,6,7)
    println(data3[2])
    println(data3.get(2))
    println(data3.size)
    data3[0] = 100
    println(data3[0])
    data3.set(1,200) //1번째에 200의 값을 넣겠다
    println(data3[1])
    println()

    val data4 = arrayOf("cat", 10, 3232.32f)
    println(data4[0])
    println(data4[1])
    println(data4[2])
    println()

    val data5 = arrayOf<String>("cat", "dog", "turtle")
    println(data5[0])
    println(data5[1])
    println(data5[2])
    println()

}