package exam1

import java.util.ArrayDeque

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
object Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    fun formatList(head: ListNode?): ListNode? {
        // write code here

        val stack = ArrayDeque<ListNode>(10)
        val emptyHead = ListNode(0)
        emptyHead.next = head
        var iter: ListNode? = emptyHead
        while (iter?.next != null) {
            stack.push(iter.next!!)
            iter.next = iter.next!!.next
            iter = iter.next
        }


        var node = emptyHead
        while (stack.isNotEmpty()) {
            node.next = stack.pop()
            node = node.next!!
        }
        node.next = head

        return emptyHead.next

    }
}