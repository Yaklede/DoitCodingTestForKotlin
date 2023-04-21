package day1

import common.Solution

class NumberSorting: Solution {
    override fun solution() {
        val num = readln().toInt()
        val sorting = mutableListOf<Int>()
        val stringBuilder = StringBuilder()
        for (i: Int in 0 until num) {
            sorting.add(readln().toInt())
        }

        sorting.sort()
        sorting.map {
            stringBuilder.append("$it\n")
        }
        println(stringBuilder.toString())
    }
}