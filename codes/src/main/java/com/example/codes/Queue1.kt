package com.example.codes

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    println(getLastRemainedCard(n))
}


// N = 4 : [1, 2, 3, 4]
private fun getLastRemainedCard(numOfCard: Int): Int {
    val queue: Queue<Int> = LinkedList()

    for (i in 1 .. numOfCard) { // 1, 2, 3, 4, 5, .... ,N
        queue.add(i)
    } // queue : [1, 2, ,3, 4,... N]

    // 마지막으로 남게 되는 카드를 구해야한다.
    while (queue.size > 1) {
        println("사이클 시작 $queue")
        // 1. 제일 위에 있는 카드 버리기
        queue.remove()
        // 2. 제일 위에 있는 카드 빼기
        val top = queue.remove()
        // 3. 방금 뺀 카드를 가장 아래에 넣기
        queue.add(top)
    } // 탈출 시 queue size -> 1 이하 1개 또는 0개.
    // 2 -> 0개로 반복문이 돌진 않을 것이다.
    // 1 -> 0 개로 될 것이다.
    return queue.remove()
}