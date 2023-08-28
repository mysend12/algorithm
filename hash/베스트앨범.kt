package hash

class 베스트앨범 {

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val albumTotalCount = mutableMapOf<String, Int>()
        val albumMap = mutableMapOf<String, MutableMap<Int, Int>>()

        for ((index, genre) in genres.withIndex()) {
            albumTotalCount[genre]?.let {
                albumTotalCount.put(
                    genre, it + plays[index]
                )
            } ?: albumTotalCount.put(genre, plays[index])

            val insideMap = albumMap[genre]
            if (insideMap == null) {
                albumMap[genre] = mutableMapOf(Pair(index, plays[index]))
            } else {
                insideMap[index] = plays[index]
            }
        }

        val answer = mutableListOf<Int>()
        albumTotalCount.toList().sortedByDescending { it.second }
            .forEach { pair ->
                val albumSortList = albumMap[pair.first]?.toList()?.sortedByDescending { it.second }!!
                answer.add(albumSortList[0].first)

                if (albumSortList.size != 1) {
                    answer.add(albumSortList[1].first)
                }
            }

        return answer.toIntArray()
    }
}