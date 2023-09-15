package heap

import java.util.*
import java.util.stream.Collectors

class 디스크_컨트롤러 {

    /**
     * 1. 시작 시간을 기준으로 정렬하는 큐 생성
     * 2. 실행 시간을 기준으로 정렬하는 큐 생성
     * 3. 시작 시간이 지난 큐를 실행 시간 정렬 큐로 이동
     * 4. 실행 시간 정렬 큐의 태스크들을 실행
     */
    fun solution(jobs: Array<IntArray>): Int {
        val startTimeQueue: PriorityQueue<IntArray> = Arrays.stream(jobs)
            .collect(Collectors.toCollection {
                PriorityQueue { o1, o2 ->
                    if (o1[0] > o2[0]) 1 else -1
                }
            })
        val durationQueue: PriorityQueue<IntArray> = PriorityQueue { o1, o2 ->
            if (o1[1] > o2[1]) 1 else -1
        }

        var count = 0
        var startTime = startTimeQueue.peek()[0]

        while (startTimeQueue.isNotEmpty()) {
            while (true) {
                if (startTimeQueue.isNotEmpty() && startTime >= startTimeQueue.peek()[0]) {
                    durationQueue.offer(startTimeQueue.poll())
                } else break
            }

            if (durationQueue.isNotEmpty()) {
                val task = durationQueue.poll()
                count += startTime + task[1] - task[0]
                startTime += task[1]
            } else {
                val task = startTimeQueue.poll()
                count += task[1]
                startTime = task[0] + task[1]
            }
            while (durationQueue.isNotEmpty()) {
                startTimeQueue.offer(durationQueue.poll())
            }
        }

        return count / jobs.size
    }

}