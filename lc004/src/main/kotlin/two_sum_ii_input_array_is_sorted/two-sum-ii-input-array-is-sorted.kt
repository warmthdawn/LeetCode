package two_sum_ii_input_array_is_sorted

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1

        while (i < j) {
            val test = numbers[j] + numbers[i]

            if (test > target) {
                j--
            } else if (test < target) {
                i++
            } else {
                return intArrayOf(i + 1, j + 1)
            }
        }

        throw NoSuchElementException()
    }
}