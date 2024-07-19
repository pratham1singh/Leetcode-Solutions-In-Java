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
    HashMap<TreeNode,ArrayList<TreeNode>> adj = new HashMap<>();
    HashMap<TreeNode,Boolean> visited= new HashMap<>();
    ArrayList<TreeNode> arr = new ArrayList<>();


    public int find(TreeNode root,int d,int max_d){
        // System.out.println(root.val+" "+d);
        if(d>max_d)
            return 0;
        else if(root.left==null&&root.right==null&&d!=0)
            return 1;
        else{
            int ans=0;
            for(TreeNode x:adj.get(root))
                if(visited.get(x)==null){
                    visited.put(x,true);
                    ans+=find(x,d+1,max_d);
                    visited.remove(x);
                }
            return ans;
        }
    }
    public void ini_adj(TreeNode root){
        if(root==null)
            return ;
        if(root.left==null&&root.right==null)
            arr.add(root);
        adj.put(root,new ArrayList<TreeNode>());
        ini_adj(root.left);
        ini_adj(root.right);
    }
    public void make_adj(TreeNode root){
        if(root==null)
            return ;
        
        if(root.left!=null){
            adj.get(root).add(root.left);
            adj.get(root.left).add(root);
            make_adj(root.left);
        }

        if(root.right!=null){
            adj.get(root).add(root.right);
            adj.get(root.right).add(root);
            make_adj(root.right);
        }
    }
    public int countPairs(TreeNode root, int distance) {
        ini_adj(root);
        make_adj(root);
        int ans=0;
        // System.out.println(adj);
        for(TreeNode x:arr){
            visited.put(x,true);
            ans+=find(x,0,distance);
            visited.remove(x);
        }
        return ans/2;
    }
}