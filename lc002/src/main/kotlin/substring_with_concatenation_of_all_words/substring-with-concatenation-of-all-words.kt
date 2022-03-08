package substring_with_concatenation_of_all_words

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val len = words[0].length
        val total = len * words.size
        words.sort()
        val result = mutableSetOf<Int>()
        for (word in words.toSet()) {
            var index = s.indexOf(word)
            while (index >= 0) {
                if (index in result) {
                    index = s.indexOf(word, index + 1)
                    continue
                }
                val possible = (index until (index + total).coerceAtMost(s.length - len + 1) step len)
                    .map {
                        s.substring(it, it + len)
                    }.toTypedArray().also { it.sort() }


                if (possible contentEquals words) {
                    result.add(index)
                }
                index = s.indexOf(word, index + 1)
            }

        }
        return result.toList()
    }
}