package search_insert_position

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size - 1
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (nums[mid] < target) {
                b = mid - 1
            } else {
                a = mid + 1
            }
        }

        return a
    }
}