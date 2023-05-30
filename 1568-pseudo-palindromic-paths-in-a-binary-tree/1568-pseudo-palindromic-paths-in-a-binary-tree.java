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

    int ans=0;
    // ArrayList<String> arr=new ArrayList<String>();
    public void find(TreeNode root,int arr[]){
        if(root==null)
            return;
        else if(root.left==null&&root.right==null){

                arr[root.val-1]+=1;
                int o=0;
                for(int i=0;i<9;i++){
                    if(arr[i]%2!=0){
                            o+=1;
                    }
                }
                if(o<=1)
                    ans+=1;
                return;
            }

            
        else{

            int arr2[]=new int[9];
            int arr3[]=new int[9];
            for(int i=0;i<9;i++){
                arr2[i]=arr[i];
                arr3[i]=arr[i];
            }
            arr2[root.val-1]+=1;
            arr3[root.val-1]+=1;
            find(root.left  ,arr2);
            find(root.right ,arr3);
        }
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int e=0,o=0;
        int arr[]=new int[9];
        find(root,arr);
        return ans;
    }
}