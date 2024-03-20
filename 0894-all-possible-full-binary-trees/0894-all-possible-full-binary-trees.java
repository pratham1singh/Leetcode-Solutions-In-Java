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
    
    public List<TreeNode> make(int n){
        if(n==1){
            List<TreeNode> arr = new ArrayList<>();
            arr.add(new TreeNode(0));
            return arr;
        }
        else{
            List<TreeNode> arr = new ArrayList<>();
            int i=1,x=n-1;
            while(i<x){
                List<TreeNode> left=make(i);
                List<TreeNode> right=make(x-i);
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root = new TreeNode(0);
                        root.left=l;
                        root.right=r;
                        arr.add(root);
                    }
                }
                i+=2;
            }
            return arr;
        }
    }
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0) return new ArrayList<TreeNode>();

        return make(n);
    }
}