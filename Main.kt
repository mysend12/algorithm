import hash.Phonecatmon
import hash.완주하지못한선수
import hash.전화번호목록

fun main() {
    println(Phonecatmon().solution(intArrayOf(3, 3, 3, 2, 2, 4)))
    println(
        완주하지못한선수().solution(
//            arrayOf("leo", "kiki", "eden"),
//            arrayOf("eden", "kiki"),
            arrayOf("mislav", "stanko", "mislav", "ana"),
            arrayOf("stanko", "ana", "mislav"),
        )
    )

    println(
        전화번호목록().solution(
            arrayOf("119", "97674223", "1195524421")
//            arrayOf("123","456","789")
//            arrayOf("12","123","1235","567","88")
        )
    )


}