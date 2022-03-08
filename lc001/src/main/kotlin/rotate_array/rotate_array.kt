package rotate_array

class Solution {

    private fun commonDivisor(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val c = a % b
            a = b
            b = c
        }
        return a
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        val k = k % nums.size
        if (k == 0) return

        val md = commonDivisor(nums.size, k)
        val mm = nums.size.toLong() * k / md

        for (j in 0 until md) {
            var tmp: Int? = null
            for (i in (k until mm step k.toLong()).reversed()) {
                val index = ((i + j) % nums.size).toInt()
                val indexPrev = ((i + j - k) % nums.size).toInt()
                if (tmp == null) {
                    tmp = nums[index]
                }
                nums[index] = nums[indexPrev]
            }
            nums[j] = tmp!!
        }
    }
}