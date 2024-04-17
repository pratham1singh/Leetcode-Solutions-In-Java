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
    ArrayList<String> arr = new ArrayList<>();
    public void dfs(TreeNode root, String s){
        if(root==null)
            return;
        else if(root.left==null&&root.right==null){
            s+=(char)(97+root.val);
            String a="";
            for(int i=0;i<s.length();i++){
                a=s.charAt(i)+a;
            }
            arr.add(a);
        }
       else{
            dfs(root.left,s+(char)(97+root.val));
            dfs(root.right,s+(char)(97+root.val));
        }
    }
    public String smallestFromLeaf(TreeNode root) {
        String s="";
        dfs(root,s);
        Collections.sort(arr);
       
        return arr.get(0);
    }
}