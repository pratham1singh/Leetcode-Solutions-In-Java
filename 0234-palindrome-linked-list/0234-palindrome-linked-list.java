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
    public boolean isPalindrome(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode ptr = head, pre = null;

        while(ptr!=null) {
            map.put(ptr,pre);
            pre = ptr;
            ptr = ptr.next;
        }
        ptr = head;

        while(ptr!= pre) {
            if(ptr.val!=pre.val) return false;
            ptr = ptr.next;
            if(ptr == pre) break;
            pre = map.get(pre);
        }
        return true;
    }
}