package day3

fun main() {
    println("과일 이름을 입력하세요:")
    val inputData1 = readLine()!!
    var strFruits = inputData1.split(" ")
    var fruits:MutableList<String> = mutableListOf<String>()
    for(fdata in strFruits){
        fruits.add(fdata)
    }

    val afterFruits = fruits.let{
        it.add("Melon")
        it.count()
    }

    println("총 과일 갯 수:$afterFruits")

    val lastItem = fruits.run{
        get(size - 1).uppercase()
    }
    println("last fruits:$lastItem")
} 

