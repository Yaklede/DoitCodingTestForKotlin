package day2

import common.Solution

class NumberSum : Solution {
    override fun solution() {
        val input = readln().toInt()
        val input2 = readln()
        val list = MutableList(input){0}
        input2.toList().forEachIndexed { index, c ->
            list[index] = c.digitToInt()
        }
        println(list.sum())
    }
}