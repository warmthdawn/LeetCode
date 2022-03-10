package remove_nth_node_from_end_of_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val begin = ListNode(0).also { it.next = head }
        var jump = begin.next
        var i = 0
        while (i < n) {
            jump = jump?.next
            i++
        }

        var curr = begin

        while (jump != null) {
            jump = jump.next
            curr = curr.next!!
        }

        curr.next = curr.next!!.next

        return begin.next
    }
}