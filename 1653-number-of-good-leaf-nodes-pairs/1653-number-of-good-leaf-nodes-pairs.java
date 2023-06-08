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

 class node{
     int d;
     TreeNode root;
     public node(TreeNode root,int d){
            this.d=d;
            this.root=root;
     }
 }
class Solution {
   
 HashMap<TreeNode,TreeNode> parent=new HashMap<>();
 HashMap<TreeNode,Integer> depth=new HashMap<>();
 ArrayList<TreeNode> leafs=new ArrayList<>();

   public void postorder(TreeNode root,int d){
       if(root!=null){
           if(root.left==null&&root.right==null)
                leafs.add(root);
           if(root.left!=null)
                parent.put(root.left,root);
           if(root.right!=null)
                parent.put(root.right,root);
           depth.put(root,d); 
           postorder(root.left,d+1);
           postorder(root.right,d+1);
       }
   }
   
       public int countPairs(TreeNode root, int distance) {
        postorder(root,0);
        parent.put(root,null);
        int n=leafs.size(),ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(leafs.get(j)!=leafs.get(i)){
                    TreeNode p=leafs.get(i);
                    TreeNode q=leafs.get(j);
                    int x=depth.get(p);
                    int y=depth.get(q);
                   
                    while(p!=q){
                        if(x==y){
                            p=parent.get(p);
                            q=parent.get(q);
                            x-=1;
                            y-=1;
                        }
                        else if(x>y){
                             p=parent.get(p);
                             x-=1;
                        }
                        else{
                            q=parent.get(q);
                             y-=1;
                        }
                    }
                    if((depth.get(leafs.get(i))-depth.get(p))+(depth.get(leafs.get(j))-depth.get(q))<=distance){
                        ans+=1;
                    }

               }
            }
        }
        return ans;
        
    }
}









