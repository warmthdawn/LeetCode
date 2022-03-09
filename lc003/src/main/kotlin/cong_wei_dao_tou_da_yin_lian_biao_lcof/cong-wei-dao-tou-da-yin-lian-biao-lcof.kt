package cong_wei_dao_tou_da_yin_lian_biao_lcof

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reversePrint(head: ListNode?): IntArray {
        return generateSequence(head) { it.next }
            .map { it.`val` }
            .constrainOnce()
            .asIterable()
            .reversed()
            .toIntArray()
    }


}