package `6eUYwP`

import java.util.ArrayDeque


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        root ?: return 0

        val stack = ArrayDeque<Pair<TreeNode, IntArray>>()
        stack.push(root to intArrayOf())

        var result = 0
        while (stack.isNotEmpty()) {
            val (node, parentSum) = stack.pop()

            val parentSize = parentSum.size
            val curr = IntArray(parentSize + 1) {
                (if (it >= parentSize) {
                    node.`val`
                } else {
                    parentSum[it] + node.`val`
                }).also { r ->
                    if (r == targetSum) {
                        result++
                    }
                }
            }
            node.left?.let { stack.push(it to curr) }
            node.right?.let { stack.push(it to curr) }
        }
        return result

    }

}