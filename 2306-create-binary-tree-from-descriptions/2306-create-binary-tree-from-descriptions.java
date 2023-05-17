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
    
    public TreeNode createBinaryTree(int[][] arr) {
        HashMap<Integer,TreeNode> map=new HashMap<Integer,TreeNode>();
        HashMap<Integer,Boolean> status=new HashMap<Integer,Boolean>();

        for(int i=0;i<arr.length;i++){
                if(map.get(arr[i][0])==null){
                        TreeNode node =new TreeNode(arr[i][0]);
                        map.put(arr[i][0],node);
                }
                if(map.get(arr[i][1])==null){
                        TreeNode node =new TreeNode(arr[i][1]);
                        map.put(arr[i][1],node);
                       
                }
                if(arr[i][2]==1){
                    map.get(arr[i][0]).left=map.get(arr[i][1]);
                    status.put(arr[i][1],true);
                    
                }
                else{
                    map.get(arr[i][0]).right=map.get(arr[i][1]);
                    status.put(arr[i][1],true);
                }
        }
        for(Integer x:map.keySet()){
            if(status.get(x)==null){
                
                return map.get(x);
            }
        }
        return null;
    }
}