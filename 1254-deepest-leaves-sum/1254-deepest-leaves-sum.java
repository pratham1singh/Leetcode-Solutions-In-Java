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
    HashMap<TreeNode,Integer> map = new HashMap<>();
    int mx=0;
    public void label(TreeNode root,int id){
        if(root!=null){
           
            map.put(root,id);
            mx=Math.max(mx,id);
            label(root.left,id+1);
            label(root.right,id+1);
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        label(root,0);
        int s=0;
        for(TreeNode x:map.keySet()){
            if(map.get(x)==mx)
                s+=x.val;
        }
        return s;
    }
}