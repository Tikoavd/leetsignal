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
    public ListNode insertionSortList(ListNode head) {
        ListNode myList = new ListNode(0);
        ListNode addIndex = myList;
        ListNode ptr = head;
        ListNode next = null;
        
        while(ptr != null){
            next = ptr.next;
            while(addIndex.next != null && addIndex.next.val < ptr.val)
                addIndex = addIndex.next;
            ptr.next = addIndex.next;
            addIndex.next = ptr;
            addIndex = myList;
            ptr = next;
        }
        return myList.next;
    }
}
