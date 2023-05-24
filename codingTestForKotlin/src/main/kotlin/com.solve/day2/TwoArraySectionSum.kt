package day2

import common.Solution

class TwoArraySectionSum : Solution {
    override fun solution() {
        val resultList = mutableListOf<Int>()
        val input = readln().split(" ").map { it.toInt() }
        val n = input[0] //배열 크기
        val m = input[1] //질의 크기
        val A = Array(n) { IntArray(n) } // 주어진 배열

        for (i: Int in 0 until n) {
            val arr = readln().split(" ").map {
                it.toInt()
            }
            for (j: Int in 0 until n) {
                A[i][j] = arr[j]
            }
        }


        //이거 그냥 공식 아닌가..? ex> 1차원 배열 일 땐 각 배열들을 더한 값을 배열에 저장한 걸 사용하는거고
        //2차원 배열일 땐 구간 합을 구하는 공식 A,B 배열이 있으면 S[A][B] = S[A][B-1] + S[A-1][B] - S[A-1][B-1] + A[A-1][B-1] 라는 형태인데
        val S = Array(n + 1) { IntArray(n + 1) { 0 } } //구간 합 배열, 구간 합을 위해서 n 사이즈보다 1크게 지정
        for (i: Int in 1..n) {
            for (j: Int in 1..n) {
                S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + A[i - 1][j - 1]
            }
        }

        //받은 질의로 결과 도출
        repeat(m) {
            val query = readln().split(" ").map {
                it.toInt()
            }
            val x1 = query[0]
            val y1 = query[1]
            val x2 = query[2]
            val y2 = query[3]
            //질의 대한 결과를 얻기 위해 S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1]
            //ex 질의가 2 2 3 4라면 S[3][4] - S[3][3] - S[2][4] + S[2][3]
            //위에 식을 잘보면 결국 1차원 배열에 사용했던 형태랑 비슷함
            resultList.add(S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1])
        }

        //결과 출력
        resultList.forEach {
            println(it)
        }
    }
}