package com.example.codes.section3

fun main() {
    val br = System.`in`.bufferedReader()

    println(factorial(5))
    println(fibo(7))
}

// 팩토리얼
fun factorial(n: Int) : Long {
    if ( n == 1) {
        return 1
    }
    return factorial(n - 1) * n
}

// 피보나치
fun fibo(n: Int) : Long {
    // 범위를 지정해야한다.
    // 끝점을 정해준다.
    if (n == 1) {
        return 1
    } else if (n == 0) {    // 0이 될 수 있는 케이스가 있기 때문에 0 처리를 해야한다.
        return 0
    }
    return fibo(n-2) + fibo(n-1)
}