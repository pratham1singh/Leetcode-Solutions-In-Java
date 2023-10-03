/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        queue.add(root);
        queue.add(null);
        int l=2;

        while(l>1){
            List<Integer> list1 = new ArrayList<>();
            Node x=queue.poll();
            l-=1;
           
            while(x!=null){
                list1.add(x.val);
                for(Node n:x.children){
                    queue.add(n);
                    l+=1;
                   
                }
                    x=queue.poll();
                    l-=1;
            }
            queue.add(null);
            l+=1;
            ans.add(list1);
        }
        return ans;
    }
}