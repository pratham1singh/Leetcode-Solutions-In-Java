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
    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null&&list2==null)
            return null;
        else if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        else if(list1.val<=list2.val){
            ListNode ans=list1;
            list1=list1.next;
            ans.next=merge(list1,list2);
            return ans;
        }
        else{
            ListNode ans=list2;
            list2=list2.next;
            ans.next=merge(list1,list2);
            return ans;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1,list2);
    }
}