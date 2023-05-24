package day2

import common.Solution
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class ChatGptResolve구간합_골드: Solution {
    companion object {
        class SegmentTree(val arr: LongArray) {
            private val tree = LongArray(arr.size * 4)
            init {
                build(1, 0, arr.size - 1)
            }

            private fun build(node: Int, start: Int, end: Int) {
                if (start == end) {
                    tree[node] = arr[start]
                } else {
                    val mid = (start + end) / 2
                    build(node * 2, start, mid)
                    build(node * 2 + 1, mid + 1, end)
                    tree[node] = tree[node * 2] + tree[node * 2 + 1]
                }
            }

            fun update(index: Int, value: Long) {
                update(1, 0, arr.size - 1, index, value)
            }

            private fun update(node: Int, start: Int, end: Int, index: Int, value: Long) {
                if (start == end) {
                    tree[node] = value
                    arr[index] = value
                } else {
                    val mid = (start + end) / 2
                    if (index <= mid) {
                        update(node * 2, start, mid, index, value)
                    } else {
                        update(node * 2 + 1, mid + 1, end, index, value)
                    }
                    tree[node] = tree[node * 2] + tree[node * 2 + 1]
                }
            }

            fun sum(left: Int, right: Long): Long {
                return sum(1, 0, arr.size - 1, left - 1, right - 1)
            }

            private fun sum(node: Int, start: Int, end: Int, left: Int, right: Long): Long {
                if (left > end || right < start) {
                    return 0
                }
                if (left <= start && right >= end) {
                    return tree[node]
                }
                val mid = (start + end) / 2
                return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right)
            }
        }
    }
    override fun solution() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val k = st.nextToken().toInt()
        val resultList = mutableListOf<Long>()

        val arr = LongArray(n)
        for (i in 0 until n) {
            arr[i] = br.readLine().toLong()
        }

        val segTree = SegmentTree(arr)

        repeat(m + k) {
            val line = br.readLine().split(" ")
            val a = line[0].toInt()
            val b = line[1].toInt()
            val c = line[2].toLong()

            when (a) {
                1 -> segTree.update(b - 1, c)
                2 -> resultList.add(segTree.sum(b, c))
            }
        }
        resultList.map {
            println(it)
        }
    }
}