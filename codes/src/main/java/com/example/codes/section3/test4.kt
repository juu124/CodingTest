package com.example.codes.section3

// 이차원 배열로 해결
val tree = Array(27) { // 배열 때문에 26이 아닌 27로 준것
    arrayOf('.', '.')   // 0번인덱스는 왼쪽 노드이고 1번인덱스는 오른쪽 노드이다.
}

fun main() {
    val br = System.`in`.bufferedReader()

    // 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
    val n = br.readLine().toInt()



    // 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
    repeat(n) {
        val input : List<Char> = br.readLine().split(" ").map { it.first() } // 문자로 이용할때 "ABCED"에서 A를 문자로 가져오기 "A"
        // 예시 : A B C
        // char -> 숫자로 바꿔서 쓸 수 있는 방법 -> 아스키 코드를 사용 -> 그리고 인덱스 번호로 사용하고 싶으니까 A의 아스키 코드를 뺀다.
        tree[input[0].code - 'A'.code][0] = input[1]
        tree[input[0].code - 'A'.code][1] = input[2]
    }

    // 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
    // 자식 노드가 없는 경우에는 .으로 표현한다.

    // 첫째 줄에 전위 순회,
    // 둘째 줄에 중위 순회,
    // 셋째 줄에 후위 순회한 결과를 출력한다.
    // 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

    // 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
    preOrder('A')
    println()
    // 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
    inOrder('A')
    println()
    // 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
    postOrder('A')
    // ABDCEFG
    //BDACEFG
    //BDCEFGA
}

// 전위 순회
fun preOrder(c: Char) {
    if (c == '.') {
        return
    }

    // (루트) (왼쪽 자식) (오른쪽 자식)
    // 루트
    print(c)
    // 왼쪽
    preOrder(tree[c.code - 'A'.code][0])
    // 오른쪽
    preOrder(tree[c.code - 'A'.code][1])
}

fun inOrder(c : Char) {
    if (c == '.') {
        return
    }

    // (왼쪽 자식) (루트) (오른쪽 자식)
    // 왼쪽
    inOrder(tree[c.code - 'A'.code][0])
    // 루트
    print(c)
    // 오른쪽
    inOrder(tree[c.code - 'A'.code][1])
}

fun postOrder(c : Char) {
    if (c == '.') {
        return
    }

    // (왼쪽 자식) (오른쪽 자식) (루트)
    // 왼쪽
    postOrder(tree[c.code - 'A'.code][0])
    // 오른쪽
    postOrder(tree[c.code - 'A'.code][1])
    // 루트
    print(c)
}