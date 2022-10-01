/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {        
        while(head != null && head.val == val) head = head.next;
        if (head == null) return head;
        ListNode prev = head;
        ListNode ptr = head.next;
        while(ptr != null){
            if(ptr.val == val){
                prev.next = ptr.next;
                ptr = ptr.next;
            }
            else {
                prev = prev.next;
                ptr = ptr.next;
            }
        }
        return head;
    }
}
