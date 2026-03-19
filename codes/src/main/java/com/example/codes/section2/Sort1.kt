package com.example.codes.section2

// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
fun main() {
    val totalNumber = readln().toInt()  // 한줄 받아오기
    val numbers = mutableListOf<Int>()

    // 토탈 수만큼 데이터를 받아오기
    repeat(totalNumber) {
        // 데이터를 받아온다.
        val num = readln().toInt()

        //  numbers라는 리스트에 하나하나 추가해준다.
        numbers.add(num)
    }

    // sort 시작
    // case : bubble sort
    val sort = bubbleSort(numbers.toIntArray())
    for (i in sort) {
        println(i)
    }
}

fun bubbleSort(numbers: IntArray) : IntArray {
    // 인접한 두 데이터를 비교한다.
    // 리스트를 쭉 한번 돈다. 하나씩 살펴보면서,
    // j번째 변수랑, j+1번째 변수를 비교해야한다.
    for (i in numbers) {
        for (j in 0 until numbers.size - 1) {
            if (numbers[j] > numbers[j + 1]) {
                // 둘이 swqp한다.
                numbers.swap(j, j+1)
            }
        }
    }
    return numbers
}

fun IntArray.swap(i: Int, j: Int) {
    //  swap : 리스트에 있는 두개의 요소들을 서로 교체해준다.
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}