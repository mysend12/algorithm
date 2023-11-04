package brute_force

import java.util.*

/**
 * DFS
 * 넓게 탐색하기전, 깊게 탐색하는것으로 모든 노드를 방문하고자 하는 경우에 선택
 *
 * 자기 자신을 호출하는 순환 알고리즘의 형태
 * 전위 순회를 포함한 다른 형태의 트리 순회는 모두 DFS의 종류
 * 어떤 노드를 방문했었는지 여부를 반드시 검사해야한다.
 * - 검사하지 않을 경우, 무한루프에 빠질 수 있다.
 *
 * 구현: 순환 혹은 스택을 이용하여 구현한다.
 *
 * BFS
 * 시작 노드에서 시작해서, 단계별로(넓게, 정의된 순서대로) 탐색
 * 어떤 노드를 방문했는지 반드시 검사해야한다.
 *
 * 구현: 큐를 이용하여 구현한다.
 */
class GraphAlgorithm {

    private val graph = listOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0, 3),
        intArrayOf(0, 3),
        intArrayOf(0, 1, 2),
    )
    private val visited = BooleanArray(graph.size)

    fun dfsWithRecursion(index: Int) {
        if (index < 0 || graph.size <= index) return
        println("visited: $index")
        visited[index] = true

        for (loopIndex in graph[index]) {
            if (!visited[loopIndex]) {
                dfsWithRecursion(loopIndex)
            }
        }
    }

    fun dfsWithStack(start: Int) {
        val stack = Stack<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            if (!visited[pop]) {
                visited[pop] = true
                println("visited: $pop")
                // 재귀와 같은 순서로 꺼내고싶다면,
                // reversed 후에 반복하거나 while문 이전에 정렬
                graph[pop].forEach {
                    if (!visited[it]) stack.push(it)
                }
            }
        }
    }

    fun bfs(start: Int) {
        val queue = LinkedList<Int>()
        queue.push(start)

        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            if (!visited[pop]) {
                visited[pop] = true
                println("visited: $pop")

                // 재귀와 같은 순서로 꺼내고싶다면,
                // reversed 후에 반복하거나 while문 이전에 정렬
                graph[pop].forEach { if (!visited[it]) queue.push(it) }
            }
        }

    }
}