package com.example.codes.section3

fun main() {
    val br = System.`in`.bufferedReader()

    // 첫째 줄에는 지방의 수를 의미하는 정수 N이 주어진다.
    val n = br.readLine().toInt()

    // 다음 줄에는 각 지방의 예산요청을 표현하는 N개의 정수가 빈칸을 사이에 두고 주어진다.
    var max = 0
    val moneys = br.readLine().split(" ").map { it.toInt() }
    // 이번에는 sort할 필요가 없다.
    moneys.forEach {
        max = Math.max(max, it)
    }

    // 그 다음 줄에는 총 예산을 나타내는 정수 M이 주어진다.
    val m = br.readLine().toInt()   // 토탈 예산

    // 예산들 중에 최대값을 high로 잡는다
    var low = 0
    var high = max
    var result = 0

    while (low <= high) {
        val mid = (low + high) / 2 // 이 값은 상한 액과 값다. 문제 예시에서 나온 127

        // 이진 트리는 업다운 게임과 같다
        // 지방 예산의 합을 구해야한다.
        var sumMoney = 0
        moneys.forEach { money ->
            if (money < mid) {
                sumMoney += money
            } else {
                sumMoney += mid
            }
        }

        if (sumMoney <= m) {
            // 정답 (범위 안이다.)
            result = mid  // 최대값 갱신
            low = mid + 1
        } else {
            // 범위를 넘었다. (예산을 초과했다.)
            high = mid - 1

        }
    }

    println(result)
}