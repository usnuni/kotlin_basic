package day3

/*
    1. 과일 목록을 입력받은 후 아래의 조건에 맞게 코드를 구성하시오

    [입력]
    과일 이름들을 입력하세요 : apple, banana, grape
    총 과일 개수 : 4
    last fruit : melon

    - 위에서 입력받은 과일 목록은 list 객체로 구성한다.
    - 리스트 객체에 melon을 추가하고 전체 과일 개수를 출력한다.
    - 과일 목록 맨 마지막 과일을 가지고 와서 대문자로 변환 후 출력한다.
        이 때 마지막 과일은 run() 사용하여 가져온다.
 */

fun main() {
    println("과일 이름들을 입력하세요:")
    var fruits:MutableList<String> = readLine()!!.split(' ').map { it.toString() } as MutableList<String>
    fruits.add("melon")

    println("총 과일 개수: ${fruits.size}")

    fruits.run{
        println("last fruit: ${fruits.last().uppercase()}")
    }

}