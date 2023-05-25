package 알고리즘_기초_1

import common.Solution

class ReverseWords: Solution {
    override fun solution() {
        val inputSize = readlnOrNull()?.toInt() ?: 0
        val stringBuilder = StringBuilder()
        for (i: Int in 0 until inputSize) {
            val sentence =  readln()
            val words = sentence.split(" ")

            words.forEach { word ->
                word.reversed().let { stringBuilder.append("$it ") }
            }
            stringBuilder.append("\n")
        }
        print(stringBuilder)
    }
}