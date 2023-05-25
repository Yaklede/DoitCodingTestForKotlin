package 알고리즘_기초_1

import common.Solution

class QueueSolution: Solution {
    companion object {
        interface Queue<T> {
            val queueList: MutableList<T>

            fun push(queueElement: T) {
                queueList.add(queueElement)
            }

            fun pushReturnsObject(queueElement: T): T {
                push(queueElement)
                return queueElement
            }

            fun pop(): T? {
                return try {
                    queueList.removeAt(0)
                } catch (e: Exception) {
                    null
                }

            }
            fun size(): Int {
                return queueList.size
            }
            fun empty(): Boolean {
                return queueList.isEmpty()
            }
            fun front(): T? {
                return try {
                    return queueList[0]
                } catch (e: Exception) {
                    null
                }
            }

            fun back(): T? {
                return try {
                    val len = queueList.size
                    queueList[len - 1]
                } catch (e: Exception) {
                    return null
                }
            }
        }

        class IntQueue : Queue<Int> {
            override val queueList: MutableList<Int> = mutableListOf()

            override fun pop(): Int {
                return super.pop() ?: -1
            }
            override fun front(): Int {
                return super.front() ?: -1
            }
            override fun back(): Int {
                return super.back() ?: -1
            }
            fun isEmptyReturnsInt(): Int {
                return if (super.empty()) {
                    1
                } else {
                    0
                }
            }
        }
    }
    override fun solution() {
        val inputSize = readlnOrNull()?.toInt() ?: 0
        val stringBuilder = StringBuilder()
        val queue = IntQueue()
        for (i: Int in 0 until inputSize) {
            var command = readln()
            var value: Int? = null

            if (command.contains(" ")) {
                command.split(" ").let {
                    command = it[0]
                    value = it[1].toInt()
                }
            }

            when(command) {
                "push" -> value?.let { queue.push(it) }
                "pop" -> queue.pop().let { stringBuilder.append("$it\n") }
                "size" -> queue.size().let { stringBuilder.append("$it\n") }
                "empty" -> queue.isEmptyReturnsInt().let { stringBuilder.append("$it\n") }
                "front" -> queue.front().let { stringBuilder.append("$it\n") }
                "back" -> queue.back().let { stringBuilder.append("$it\n") }
            }
        }
        print(stringBuilder)
    }
}