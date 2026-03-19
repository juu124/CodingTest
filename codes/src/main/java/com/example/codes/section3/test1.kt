package com.example.codes.section3
// 1. 입력 부분을 긁어온다.

fun main() {
    val br = System.`in`.bufferedReader()
    // 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
    val n = br.readLine().toInt()
    // 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    val a : List<Int> = br.readLine().split(" ").map { it.toInt() }.sorted()
    // 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    val m = br.readLine().toInt()
    // 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
    val b: List<Int> = br.readLine().split(" ").map { it.toInt() }

    // 여기까지만 하면 입력을 받을 수 있게 되었다.

    repeat(m) {index ->
        var low = 0
        var high = n - 1 // n개의 수이고 인덱스로 계산해야하므로 -1
        val answer = b[index]
        var isFind = false

        while (low <= high) {
            val mid = (low + high) / 2
            val currentNumber = a[mid]

            if (currentNumber == answer) {
                // 정답
                isFind = true
                break
            } else if (currentNumber < answer) {
                // low를 올려줘야한다.
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        if (isFind) {
            println(1)
        } else {
            println(0)
        }
    }

    // set을 사용해도 된다.
    val c : List<Int> = br.readLine().split(" ").map { it.toInt() }.sorted()
    repeat(m) {
        c.contains(b[it])
        if (a.contains(b[it])) println(1) else println(0)
    }

    // 출력을 println이 아닌 StringBuilder()를 사용한다. 시간 지연을 줄여준다.
    val sb = java.lang.StringBuilder()
    var str: String = ""
    repeat(m) {
        if (a.contains(b[it])) sb.append("1\n") else sb.append("0\n")
    }
    println(sb.toString())  // 딱 1번만 println 사용하기
}