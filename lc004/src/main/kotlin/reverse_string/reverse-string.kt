package reverse_string

class Solution {
    fun reverseString(s: CharArray): Unit {
        (0..s.size / 2).forEach {
            val oppo = s.size - it - 1
            val tmp = s[it]
            s[it] = s[oppo]
            s[oppo] = tmp
        }
    }
}