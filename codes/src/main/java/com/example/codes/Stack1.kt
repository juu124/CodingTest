package com.example.codes

import java.util.Stack

// happy -> [h, a, p, p, y] -> [y, p, p, a, h]
private fun reverse(input: String): String {
    val stack = Stack<Char>() // String -> char
    val string = StringBuilder()
    val answer = StringBuilder()

    // 공백 기준으로 문자를 잘라달라
    val words = input.split(" ")

    for (word in words) { // I -> am -> happy
        val stack = Stack<Char>()
        for (c in word) { // h -> a -> p -> p -> y
            stack.push(c) // [h, a, p, p, y]
        }

        // 스택이 비어있지 않을 때까지 반복
        while (stack.isNotEmpty()) {
            string.append(stack.pop()) // yppah
        }
        answer.append(" ")
    }
    return answer.toString()
}

fun main() {
    println(reverse("I am happy today"))
    println(reverse("We want to win the first prize"))
}