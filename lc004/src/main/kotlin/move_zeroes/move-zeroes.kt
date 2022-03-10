package move_zeroes

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val begin = nums.indexOf(0)
        if (begin < 0 || begin == nums.size - 1) {
            return
        }
        var zeroIndex = begin
        for (i in (begin + 1 until nums.size)) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i]
                nums[i] = 0
                zeroIndex++
            }
        }
    }
}