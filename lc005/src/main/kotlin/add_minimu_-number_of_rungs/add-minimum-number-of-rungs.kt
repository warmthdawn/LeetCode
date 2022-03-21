class Solution {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        return (sequenceOf(0) + rungs.asSequence()).windowed(2).map { (a, b) -> (b - a - 1) / dist }.sum()
    }
}