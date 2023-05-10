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
    Map<Integer,Integer> dict1=new HashMap<Integer,Integer>();
    public int add(TreeNode root){
        if(root==null)
            return 0;
        else
            return root.val+add(root.left)+add(root.right);
    }
    public void solve(TreeNode root){
                if(root!=null){
                    int s=add(root);
                    if(dict1.get(s)!=null){
                        dict1.put(s,dict1.get(s)+1);
                    }
                    else
                        dict1.put(s,1);
                    solve(root.left);
                    solve(root.right);
                }
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        solve(root);
        int mx=-1,count=0,i=0;

        for(int x:dict1.values()){
            if(mx<x)
                mx=x;
        }
        for(int x:dict1.values()){
            if(x==mx)
                count+=1;
        }
        int arr[]= new int [count];
        for(int x:dict1.keySet()){
            if(dict1.get(x)==mx){
                arr[i]=x;
                i+=1;
            }
        }
        
        return arr;
    }
}