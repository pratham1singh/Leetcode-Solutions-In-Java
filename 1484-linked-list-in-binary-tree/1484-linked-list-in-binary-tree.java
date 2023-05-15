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
    ArrayList<TreeNode>arr=new ArrayList<>();
    public void search(TreeNode root,int key){
        if(root!=null){
            
            
                if(root.val==key)
                    arr.add(root);
                search(root.left,key);
                search(root.right,key);

        }
    }
    public boolean check(TreeNode root,ListNode head){
        
            if(head==null)
                return true;
            else if(root==null)
                return false;
            else if(root.val==head.val){
                return check(root.left,head.next)||check(root.right,head.next);
            }
            else
                return false;
        
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        search(root,head.val);
        System.out.println(arr.size());
        for(TreeNode x:arr){
            if(check(x,head))
                return true;
        }
        return false;
    }
}


