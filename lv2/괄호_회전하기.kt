package lv2

import java.util.Stack

fun main() {

    fun checkString(
        s: String,
        index: Int,
        stack: Stack<Char>,
        result: Int,
    ): Int = when {
        result == 0 -> 0
        index == s.length -> if (stack.isEmpty()) 1 else 0
        else -> {
            val answer = when (s[index]) {
                '[', '{', '(' -> {
                    stack.push(s[index])
                    1
                }
                ']' -> if (stack.isNotEmpty() && stack.pop() == '[') 1 else 0
                '}' -> if (stack.isNotEmpty() && stack.pop() == '{') 1 else 0
                ')' -> if (stack.isNotEmpty() && stack.pop() == '(') 1 else 0
                else -> 0
            }
            checkString(
                s = s,
                index = index + 1,
                stack = stack,
                result = answer,
            )
        }
    }

    fun tailRecursive(
        s: String,
        index: Int,
        count: Int,
    ): Int = when (index == s.length) {
        true -> count
        false -> tailRecursive(
            s = "${s.drop(1)}${s[0]}",
            index = index + 1,
            count = count + checkString(
                s = s,
                index = 0,
                stack = Stack(),
                result = 1,
            )
        )
    }

    fun solution(s: String): Int = tailRecursive(s, 0, 0)

    println(
//        solution("[](){}"),
//        solution("}]()[{"),
//        solution("[)(]"	),
//        solution("}}}"),
//        solution("[]}}}"),
//        solution("]["),
        solution("{(})")
    )
}