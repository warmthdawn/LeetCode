package find_bottom_left_tree_value

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        return findImpl(root!!, 0).second
    }

    fun findImpl(node: TreeNode, depth: Int): Pair<Int, Int> {
        if (node.left == null && node.right == null) {
            return depth to node.`val`
        }
        if (node.left == null) {
            return findImpl(node.right!!, depth + 1)
        }
        if (node.right == null) {
            return findImpl(node.left!!, depth + 1)
        }
        val (dl, vl) = findImpl(node.left!!, depth + 1)
        val (dr, vr) = findImpl(node.right!!, depth + 1)

        return if (dl >= dr) {
            dl to vl
        } else {
            dr to vr
        }
    }

}