package squares_of_a_sorted_array

class Solution {
    fun findZero(nums: IntArray): Int {
        var a = 0
        var b = nums.size - 1
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (nums[mid] <= 0) {
                b = mid - 1
            } else {
                a = mid + 1
            }
        }

        return a
    }
    fun sortedSquares(nums: IntArray): IntArray {
        val zero = findZero(nums)
        var i = zero
        var j = zero + 1
        val result = mutableListOf<Int>()
        while (i >= 0 && j < nums.size) {
            val a = nums[i]
            val b = nums[j]
            if (a + b > 0) {
                result.add(a * a)
                i--
            } else {
                result.add(b * b)
                j++
            }
        }

        while (i >= 0) {
            val a = nums[i]
            result.add(a * a)
            i--
        }

        while (j < nums.size) {
            val b = nums[j]
            result.add(b * b)
            j++
        }

        return result.toIntArray()
    }
}