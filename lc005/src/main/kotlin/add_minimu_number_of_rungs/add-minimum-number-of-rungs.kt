package add_minimu_number_of_rungs

class Solution {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        return (sequenceOf(0) + rungs.asSequence()).windowed(2).map { (a, b) -> (b - a - 1) / dist }.sum()
    }
}