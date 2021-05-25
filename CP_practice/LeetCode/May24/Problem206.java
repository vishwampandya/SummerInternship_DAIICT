/*206. Reverse Linked List*/
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
    public ListNode reverseList(ListNode head) {
        
        /*
        //iterative-----------------------------------------------
        ListNode temp = new ListNode();
        temp = null;
        while(head!=null){
            ListNode newNode = new ListNode(head.val);
            newNode.next = temp;
            temp = newNode;
            head = head.next;
        }
        return temp;
        */
        
        
        
        /*
        //iterative without memory usage------------------------------------------
        ListNode prev = null;
        ListNode nxt ;
        boolean flag=false;
        if(head!=null){
            nxt = head.next;
        }
        else{
            nxt=null;
            flag=true;
        }        
        while(nxt!=null){
            head.next = prev;
            prev = head;
            head = nxt;
            nxt = nxt.next;
        }
        if(!flag)
            head.next = prev;
        return head;
        */
        
        
       
        //recursive-----------------------------------------------
        if(head==null || head.next==null) return head;
        
        ListNode l = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return l;
    }
}
