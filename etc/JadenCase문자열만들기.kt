package etc

fun main() {
    println(JadenCase문자열만들기().solution("for the last week"))
}
class JadenCase문자열만들기 {

    fun solution(s: String): String = recursion("", s, 0, true)

    private tailrec fun recursion(result: String, input: String, index: Int, isUpper: Boolean = false): String = when (index) {
        input.length -> result
        else -> {
            val indexChar = if (isUpper) input[index].uppercaseChar() else input[index].lowercaseChar()
            recursion(result + indexChar, input, index + 1, input[index] == ' ')
        }
    }

}