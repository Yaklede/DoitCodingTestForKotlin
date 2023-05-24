package day2

import common.Solution
import java.lang.StringBuilder

class SectionSum : Solution {
    override fun solution() {
        val input = readln()
        val input2 = readln()
        val inputList1 = input.split(" ").toMutableList()
        val defaultArray = input2.split(" ").map { it.toInt() }.toMutableList()
        //구간 합 배열을 위한 0번지 초기화
        defaultArray.add(0, 0)
        val resultList = mutableListOf<Int>()
        val S = MutableList(defaultArray.size) { 0 }
        //구간 합 배열 생성
        for (i: Int in 1 until defaultArray.size) {
            S[i] = S[i - 1] + defaultArray[i]
        }

        for (i: Int in 0 until inputList1[1].toInt()) {
            val indexList = readln().split(" ").map { it.toInt() }.toMutableList()
            val result = S[indexList[1]] - S[indexList[0] - 1]
            resultList.add(result)
        }
        val sb = StringBuilder()
        resultList.forEach {
            sb.append("$it\n")
        }
        println(sb.toString())
    }
}