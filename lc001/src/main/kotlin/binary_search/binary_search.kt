package binary_search

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val r = nums.binarySearch(target)
        return if(r >= 0) r else -1
    }
}