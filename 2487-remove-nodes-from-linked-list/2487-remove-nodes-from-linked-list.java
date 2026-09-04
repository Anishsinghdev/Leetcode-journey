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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp = temp.next;
        }
        int maxright = Integer.MIN_VALUE;
        ListNode result = null;

        while(!st.empty()){
            ListNode current = st.pop();
            if(current.val>=maxright){
               maxright= current.val;
               current.next = result;
               result = current;

            }

        }
        return result;
        
    }
}