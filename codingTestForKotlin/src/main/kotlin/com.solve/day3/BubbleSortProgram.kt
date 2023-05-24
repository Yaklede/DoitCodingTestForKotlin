package day3

import common.Solution

class BubbleSortProgram : Solution {
    override fun solution() {
        val N = readln().toInt()
        val arrayInput = readln().split(" ").map { it.toInt() }.toMutableList()
        if (arrayInput.size != N) throw IllegalArgumentException("사이즈가 맞지 않습니다.")
        var count = 0;
        val sorted = arrayInput.sorted()
        while (arrayInput != sorted) {
            var size = 1;
            for (i: Int in 0 until arrayInput.size) {
                if (size < arrayInput.size) {
                    if (arrayInput[i] > arrayInput[size]) {
                        var temp = arrayInput[i]
                        arrayInput[i] = arrayInput[size]
                        arrayInput[size] = temp
                        size++
                        count++
                    } else {
                        var temp = arrayInput[size]
                        arrayInput[size] = arrayInput[i]
                        arrayInput[i] = temp
                        size++
                        count++
                    }
                }
            }
        }
        println(count)
    }
}