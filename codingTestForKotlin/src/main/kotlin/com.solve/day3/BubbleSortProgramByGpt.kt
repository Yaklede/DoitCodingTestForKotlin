package day3

import common.Solution

class BubbleSortProgramByGpt: Solution {
    private var arr: IntArray = intArrayOf()
    var temp: IntArray = intArrayOf()
    private var cnt: Long = 0
    override fun solution() {
        val n = readln().toInt()
        arr = readln().split(" ").map { it.toInt() }.toIntArray()
        temp = IntArray(n)

        mergeSort(0, n - 1)
        println(cnt)
    }
    private fun mergeSort(start: Int, end: Int) {
        if (start >= end) {
            return
        }

        val mid = (start + end) / 2
        mergeSort(start, mid)
        mergeSort(mid + 1, end)
        merge(start, mid, end)
    }

    private fun merge(start: Int, mid: Int, end: Int) {
        var i = start
        var j = mid + 1
        var k = start

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]
            } else {
                temp[k++] = arr[j++]
                cnt += (mid - i + 1).toLong()
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++]
        }

        while (j <= end) {
            temp[k++] = arr[j++]
        }

        for (x in start..end) {
            arr[x] = temp[x]
        }
    }
}