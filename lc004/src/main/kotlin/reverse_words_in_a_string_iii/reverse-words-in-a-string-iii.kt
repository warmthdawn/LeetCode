package reverse_words_in_a_string_iii
class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").asSequence().map { it.reversed() }.joinToString(" ")
    }
}