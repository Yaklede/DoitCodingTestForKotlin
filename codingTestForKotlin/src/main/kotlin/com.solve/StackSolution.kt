import common.Solution

class StackSolution : Solution {

    companion object {
        interface Stack<T> {
            val stackList: MutableList<T>

            fun push(t: T) {
                stackList.add(t)
            }

            fun pushReturnsObject(t: T): T {
                push(t)
                return t
            }

            fun pop(): T

            fun top(): T

            fun size(): Int {
                return stackList.size
            }

            fun empty(): Boolean {
                return stackList.isEmpty()
            }

            fun emptyReturnsInt(): Int {
                return if (empty()) {
                    1
                } else {
                    0
                }
            }
        }

        class IntStack: Stack<Int> {
            override val stackList: MutableList<Int> = mutableListOf()

            override fun top(): Int {
                return try {
                    val len = stackList.size
                    return stackList[len -1]
                } catch (e: Exception) {
                    -1
                }
            }

            override fun pop(): Int {
                return try {
                    stackList.removeAt(stackList.size - 1)
                } catch (e: Exception) {
                    -1
                }
            }
        }
    }

    override fun solution() {
        val inputSize = readlnOrNull()?.toInt() ?: 0
        val stack = IntStack()
        val stringBuilder = StringBuilder()
        for (i: Int in 0 until inputSize) {

            var command = readln()
            var value: Int? = null

            if (command.contains(" ")) {
                val stringList = command.split(" ")
                command = stringList[0]
                value = stringList[1].toInt()
            }

            when(command) {
                "push" -> value?.let { stack.push(it) }
                "pop" -> stack.pop().also { stringBuilder.append("$it\n") }
                "size" -> stack.size().also { stringBuilder.append("$it\n") }
                "empty" -> stack.emptyReturnsInt().also { stringBuilder.append("$it\n") }
                "top" -> stack.top().also { stringBuilder.append("$it\n") }
            }
        }
        print(stringBuilder)
    }
}