package first_bad_version

import kotlin.random.Random

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var a = 1
        var b = n
        var bad = false
        while (a <= b) {
            val mid = a + (b - a) / 2
            bad = isBadVersion(mid)
            if (bad) {
                b = mid - 1
            } else {
                a = mid + 1
            }
        }

        return a
    }
}

abstract class VersionControl {
    private val bad: Int = 23
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean = version < 23
}
