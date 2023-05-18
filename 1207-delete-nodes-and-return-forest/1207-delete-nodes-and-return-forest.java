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
    HashMap<Integer,TreeNode> parent=new HashMap<>();
     HashMap<Integer,TreeNode> address=new HashMap<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        parent.put(root.val,null);
        int l=1;
        while(l>0){
                TreeNode x=queue.remove();
                address.put(x.val,x);
                l-=1;
                if(x.left!=null){
                    parent.put(x.left.val,x);
                    queue.add(x.left);
                    l+=1;
                }
                if(x.right!=null){
                    parent.put(x.right.val,x);
                    queue.add(x.right);
                    l+=1;
                }
        }
        ArrayList<TreeNode> ans=new ArrayList<>();
        for(Integer x:to_delete){

                if(ans.contains(address.get(x))){
                    ans.remove(address.get(x));
                }
                if(parent.get(x)!=null){
                    if(parent.get(x).left!=null&&parent.get(x).left.val==x)
                        parent.get(x).left=null;
                    else
                        parent.get(x).right=null;
                }
                if(address.get(x).left!=null)
                    ans.add(address.get(x).left);
                if(address.get(x).right!=null)
                    ans.add(address.get(x).right);
                address.put(address.get(x).val,null);
        }
        if(address.get(root.val)!=null)
            ans.add(root);
       
        return ans;

    }
}