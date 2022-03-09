package guess_number_higher_or_lower

import kotlin.random.Random

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

abstract class GuessGame {
    abstract fun guessNumber(n: Int): Int
    fun guess(num: Int): Int = -1
}

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        return doGuess(1, n)
    }

    fun doGuess(a: Int, b: Int): Int {
        if (a == b) {
            return a
        }
        val g = (a..b).random()
        return when (guess(g)) {
            0 -> g
            -1 -> doGuess(a, g - 1)
            1 -> doGuess(g + 1, b)
            else -> throw IllegalArgumentException()
        }
    }


}