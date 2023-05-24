package day2

import common.Solution

class NewAverage: Solution {
    override fun solution() {
        // 새로운 평균 공식 모든 점수에 최고점을 나눈 후 100을 곱한 값
        val input = readln().toInt()
        val input2 = readln()
        val list = input2.split(" ").map { it.toDouble() }.toMutableList()
        if (list.size != input) throw IllegalArgumentException("사이즈가 일치 하지 않습니다.")
        val result = list.sum() * 100 / list.max() / list.size
        println(result)
    }
}