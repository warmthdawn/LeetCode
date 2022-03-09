package splitting_a_string_into_descending_consecutive_values

import kotlin.math.min

class Solution {
    fun splitString(s: String): Boolean {
        val bg = s.firstNotZero()
        if(bg < 0) {
            return false
        }
        return (bg..min(s.length - 2, bg + (s.length - bg) / 2 + 1))
            .asSequence()
            .map {
                s.substring(0..it)
            }
            .map {
                it.toLong()
            }
            .filter {
                test(s, 0, it)
            }
            .any()
    }

    private fun String.firstNotZero(startIndex: Int = 0): Int {
        var i = startIndex
        while (this[i] == '0') {
            i++
            if (i >= this.length) {
                return -1
            }
        }
        return i
    }

    private fun test(s: String, begin: Int, num: Long): Boolean {
        val testStr = num.toString()
        val i = s.firstNotZero(begin)
        if(i < 0) {
            return num == 0L
        }
        if (!s.regionMatches(i, testStr, 0, testStr.length)) {
            return false
        }
        val next = i + testStr.length
        if (next >= s.length) {
            return next == s.length
        }
        return test(s, i + testStr.length, num - 1)


    }
}