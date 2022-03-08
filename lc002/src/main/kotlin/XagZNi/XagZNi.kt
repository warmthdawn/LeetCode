package XagZNi

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val forward = mutableListOf<Int>()
        val backward = mutableListOf<Int>()

        for (asteroid in asteroids) {

            if (asteroid > 0) {
                forward.add(asteroid)
            } else {
                while (forward.isNotEmpty() && forward.last() + asteroid < 0) {
                    forward.removeAt(forward.lastIndex)
                }

                if (forward.isEmpty() || forward.last() + asteroid < 0) {
                    backward.add(asteroid)
                }
                if(forward.isNotEmpty() && forward.last() + asteroid == 0) {
                    forward.removeAt(forward.lastIndex)
                }
            }

        }

        return (backward + forward).toIntArray()

    }
}