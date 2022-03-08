package non_decreasing_array

class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        if (nums.size < 3)
            return true

        var checked = false
        for (i in 0 until nums.size - 1) {
            if (nums[i] > nums[i + 1]) {
                if (checked) {
                    return false
                }
                if((i < nums.size - 2 && nums[i] > nums[i + 2]) && (i > 0 && nums[i - 1] > nums[i + 1])) {
                    return false
                }
                checked = true
            }
        }
        return true
    }
}