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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode toBST(int i,int j,int arr[]){
        if(i>j)
            return null;
        else{
            int mid=(i+j)/2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left= toBST(i,mid-1,arr);
            node.right=toBST(mid+1,j,arr);
            return node;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        int n=0,arr[],i=0;
        ListNode ptr=head;
        while(ptr!=null){
            n++;
            ptr=ptr.next;
        }
        arr= new int[n];
        ptr=head;
        while(ptr!=null){
            arr[i]=ptr.val;
            i++;
            ptr=ptr.next;
        }
        return toBST(0,n-1,arr);
    }
}