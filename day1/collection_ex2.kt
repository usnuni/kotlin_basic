package day1

fun main() { // 파이썬 딕셔너리랑 같은 구조 - map
    val mdata1 = mapOf<String, Any>(Pair("name", "kim"), Pair("age", 20))
    println(mdata1)
    println(mdata1["age"])
    println(mdata1.get("age"))
    //안에있는 값변화 x 바꿔주고 싶으면 mutable

    println()

    val mdata2 = mutableMapOf<String, Any>(Pair("name", "kim"), Pair("age", 20))
    mdata2["name"] = "oh"
    println(mdata2)
    mdata2.set("age", 40)
    println(mdata2)
    mdata2.put("weight", 60)
    println(mdata2)
    mdata2["city"] = "seoul" //put과 같은 형태, 없는걸 말하면 추가해줌
    println(mdata2)
}