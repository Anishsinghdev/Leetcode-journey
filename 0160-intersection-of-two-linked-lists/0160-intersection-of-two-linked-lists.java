
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

       ListNode temp = headA;
       ListNode temp2 = headB;
      while(temp != temp2){
        if(temp == null){
            temp = headB;
        }else{
            temp = temp.next;
        }

        if(temp2 == null){
            temp2 = headA;
        }
        else{
            temp2 = temp2.next;
        }

      }
      return temp;
    }
}