package com.example.codes.section2

import java.util.PriorityQueue

class Sort2 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        // N : 마을의 개수
        // road: 길의 정보 (a: 출발노드, b: 도착노드, c: 걸리는 시간)
        // k : 음식배달이 가능한 최소시간.

        // 1. 그래프를 인접리스트로 만들기
        val graph = Array(N + 1) {
            arrayListOf<Node>()
        }
        road.forEach { array -> // [1, 2, 1] 이런 형식으로 들어온다.
            val (a, b, e) = array   // kotlin의 문법
            graph[a].add(Node(b, e))
            graph[b].add(Node(a, e))    // 양방향으로 연결된다는 조건이 있기 때문에
        }

        val shortest = dijkstra(1, graph)

        return answer
    }

    // 최단 거리 계산
    fun dijkstra(startNode: Int, graph: Array<ArrayList<Node>>) {
        // 최단 거리 배열 최기화
        val distance = IntArray(graph.size) { Int.MAX_VALUE }
        // 한번 방문한 곳은 가지말아야 한다는 조건이 있었음
        // 방문 여부를 체크하는 배열
        val visited = BooleanArray(graph.size) { false }
        // [false, false, false, false, false]

        // 내가 다음으로 방문 예정인 애를 고를건데,
        // 지금 최단거리 배열에 있는 애중에 값이 작은 애를 기준으로 뽑아서 알려줘.
        val pq = PriorityQueue<Node>()

        // 출발점 초기화
        distance[startNode] = 0
        pq.add(Node(startNode, 0))

        while (pq.isNotEmpty()) {
            // 현재 방문한 노드를 하나 queue에서 꺼내준다.
            val current = pq.remove()

            if (visited[current.index] == true) continue
            visited[current.index] = true

            val neighbors = graph[current.index]

            for (neighbor in neighbors) {
                // neighbors는 listOf(Node(2, 3), Node(3, 3))
                // neighborsms Node(2, 3), Node(3, 3)
                // 최단거리배열에서 현재노드 최단거리 갑과 현재 내가 갈 neighbor의 가중치를 더했을 때
                // 최단거리배열의 내가 갈 neighbor의 최단거리가 더 크면
                // neighbor의 최단 거리르 갱신해!

                if (distance[current.index] + neighbor.time < distance[neighbor.index]) {
                    distance[neighbor.index] = distance[current.index] + neighbor.time
                    pq.add(Node(neighbor.index, distance[neighbor.index]))
                }
            }
        }
    }

    data class Node (
        val index: Int, // 마을의 번호
        val time: Int   // 시간
    ) : Comparable<Node> {
        // 30, 3을 비교해
        // this가 30이고, 3이 other
        // 30 - 3 > 0
        // 3 -> 30 => 오름차순이 된거

        // this가 3으로 들어오고 3이 other로 들어와
        // 3 - 30 < 0
        // 3 -> 30 => 오름차순이 된거
        override fun compareTo(other: Node): Int {
            // 우선순위 기준
            // 오름차순을 하고 싶으면 작은게 먼저 나와야하고
            // 내림차순을 하고 싶으면 큰게먼저 나와야 한다.
            return this.time - other.time
        }
    }
}