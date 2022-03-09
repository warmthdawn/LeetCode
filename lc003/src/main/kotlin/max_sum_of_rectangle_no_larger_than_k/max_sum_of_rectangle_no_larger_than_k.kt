package max_sum_of_rectangle_no_larger_than_k

import kotlin.math.sign


class Solution {

    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {

        val lineSums = matrix.map { line ->
            val size = line.size
            Array(size) { i ->
                var sum = 0
                IntArray(size - i) { j ->
                    sum += line[i + j]
                    sum
                }
            }
        }


        val columns = matrix[0].size
        val lines = matrix.size

        var max = Int.MIN_VALUE
        (0 until columns)
            .forEach { x1 ->
                (0 until columns - x1)
                    .forEach { xp ->
                        for (y1 in (0 until lines)) {
                            var sum = 0
                            for (y2 in (y1 until lines)) {
                                sum += lineSums[y2][x1][xp]
                                if (sum <= k) {
                                    max = if (sum > max) sum else max
                                }
                            }
                        }
                    }
            }
        return max
    }
}

//TLE
class SolutionDeprecated {


    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {


        val lineSums = matrix.map {
            val listIt = it.asList()
            it.indices.map { a ->
                (a until it.size)
                    .map { b ->
                        listIt
                            .subList(a, b + 1)
                            .sum()
                    }
                    .toTypedArray()
            }.toTypedArray()
        }


        val columns = matrix[0].size
        val lines = matrix.size
        return (0 until columns)
            .asSequence()
            .flatMap { x1 ->
                (0 until columns - x1)
                    .asSequence()
                    .flatMap { x2p ->
                        (0 until lines)
                            .asSequence()
                            .flatMap { y1 ->
                                (y1 until lines)
                                    .asSequence()
                                    .map { y2 ->
                                        (y1..y2)
                                            .asSequence()
                                            .map { y0 ->
                                                lineSums[y0][x1][x2p]
                                            }
                                            .sum()
                                    }
                            }
                    }
            }
            .filter {
                it <= k
            }
            .max()!!
    }
}