package reverse_string

class Solution {

    private fun CharArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }

    fun reverseString(s: CharArray): Unit {
        (0..s.size / 2).forEach { s.swap(it, s.size - it - 1) }
    }
}