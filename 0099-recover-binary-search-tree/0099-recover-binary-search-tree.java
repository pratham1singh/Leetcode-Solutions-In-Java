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
    HashMap<Integer,TreeNode>map =new HashMap<>();
    ArrayList<Integer> list1 =new ArrayList<>();
    int n=0;
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list1.add(root.val);
            map.put(root.val,root);
            n+=1;
            inorder(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        ArrayList<Integer> list2 =(ArrayList)list1.clone();
        Collections.sort(list2);
        for(int i=0;i<n;i++){
            if(list1.get(i)!=list2.get(i)){
                map.get(list1.get(i)).val=list2.get(i);
            }
        }
    }
}