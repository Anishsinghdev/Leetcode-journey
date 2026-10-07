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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null){
            return null;
        }
        ListNode frist = head;
        ListNode second = head;
        int count = 0;
        while(frist != null){
            frist = frist.next;
            count++;
        }
        int loopcount = count-n;

         if (n == count) {
            return head.next;
        }
        
        for(int i=1;i<loopcount;i++){
            second = second.next;
        }
        second.next = second.next.next;
        
        return head;
    }
}