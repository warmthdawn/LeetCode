package middle_of_the_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head!!
        var fast = head.next ?: return slow

        while (fast.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next!!
            slow = slow.next!!
        }
        return slow.next
    }
}