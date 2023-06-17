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
    List<List<Integer>> ans = new ArrayList<>();
    public void find(int sum,List arr,TreeNode root,int target){
      System.out.println(sum);
        if(sum==target&&(root.left==null&&root.right==null)){
            List<Integer> list1 =new ArrayList<>(arr);
            ans.add(list1);
            return;
        }
       
        else{
        if(root.left!=null){
        arr.add(root.left.val);
        find(sum+root.left.val,arr,root.left,target);
        arr.remove(arr.size()-1);
        }
         if(root.right!=null){
        arr.add(root.right.val);
        find(sum+root.right.val,arr,root.right,target);
        arr.remove(arr.size()-1);
        }

        }

        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> list1 =new ArrayList<>();
        if(root==null)
            return ans;
        list1.add(root.val);
        find(root.val,list1,root,targetSum);
        return ans;
    }
}