package detect_squares

class DetectSquares() {

    //映射 x -> y -> 点数量
    private val points = mutableMapOf<Int, MutableMap<Int, Int>>()


    fun add(point: IntArray) {
        val (x, y) = point
        this.points.computeIfAbsent(x) { mutableMapOf() }.compute(y) { _, v -> if (v == null) 0 else v + 1 }
    }

    fun count(point: IntArray): Int {
        val (x, y) = point

        var result = 0
        this.points[x]?.forEach { (y1, fy) ->
            val len = y1 - y
            if (len != 0) {
                for (i in intArrayOf(-len, len)) {
                    this.points[x + i]?.let {
                        it[y]?.let { fx -> it[y1]?.times(fx) }
                    }?.let {
                        result += fy * it
                    }
                }
            }
        }
        return result
    }

}