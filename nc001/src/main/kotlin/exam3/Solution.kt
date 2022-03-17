package exam3

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型一维数组
     * @return long长整型
     */
    fun minimum(a: IntArray): Long {
        // write code here
        var total = 0L
        var max = 0

        for (num in a) {
            total += num
            max = max(max, num)
        }

        val avgMax = (total / max).toInt()

        val minStep = min(avgMax, a.size - avgMax)

        var result = Long.MAX_VALUE
        for (i in (0 until a.size - minStep)) {
            var sum = 0L
            if (minStep > 0) {
                for (n in (i until i + minStep)) {
                    sum += a[n]
                }
            }
            for (j in (i + minStep until a.size)) {
                sum += a[j]
                val r = sum * 2 - total
                val abs = abs(r)
                if (r > 0 && abs >= result) {
                    break
                }
                if (abs < result) {
                    result = abs
                }
            }
        }

        return result
    }
}