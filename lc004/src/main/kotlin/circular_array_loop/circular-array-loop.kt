package circular_array_loop

class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        fun Int.next(): Int {
            return ((nums[this] + this) % nums.size + nums.size) % nums.size
        }

        infix fun Int.directionSame(other: Int): Boolean {
            return nums[this] * nums[other] > 0
        }

        for (i in nums.indices) {
            var fast = i.next()
            var slow = i
            while (slow directionSame fast && slow directionSame fast.next()) {
                if (fast == slow) {
                    if (slow == slow.next()) {
                        break
                    }
                    return true
                }
                fast = fast.next().next()
                slow = slow.next()
            }
        }
        return false
    }
}