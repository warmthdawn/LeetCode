package longest_substring_without_repeating_characters
import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastIndexes = mutableMapOf<Char, Int>()
        var bg = -1
        var result = 0
        for (i in s.indices) {
            val ch = s[i]
            val chi = lastIndexes[ch]
            if (chi != null) {
                bg = max(bg, chi)
            }
            result = max(result, i - bg)
            lastIndexes[ch] = i

        }
        return result;
    }
}