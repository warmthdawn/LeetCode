object Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @param k int整型
     * @return long长整型
     */
    fun ans(array: IntArray, k: Int): Long {
        // write code here
        array.sort()

        var result = 0L

        for (i in (0 .. array.size - 2)) {
            val ai = array[i]
            if (ai > k * 2) {
                break
            }
            for (j in (i + 1 until array.size)) {
                val aj = array[j]
                if (ai + aj > k) {
                    break
                }
                result++
            }
        }
        return result
    }
}