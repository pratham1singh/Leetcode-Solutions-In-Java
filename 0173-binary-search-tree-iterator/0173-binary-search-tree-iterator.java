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
class BSTIterator {

    ArrayList<Integer> list1 =new ArrayList<>();
    int n=0,i=0;
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list1.add(root.val);
            n+=1;
            inorder(root.right);
        }
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
        this.i=0;
    }
    
    public int next() {
        int x=i;
        i+=1;
        return list1.get(x);
        
    }
    
    public boolean hasNext() {
        if(i>=n)
            return false;
        else
            return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */