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
    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer,List<Integer>>map = new HashMap<>();
    int mx=0;
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)
            return ans;
        dfs(root,0);
        for(int i=0;i<=mx;i++)
            ans.add(map.get(i));
        return ans;
    }
    public void dfs(Node root,int level){
        mx=Math.max(mx,level);
        if(map.get(level)==null)
            map.put(level,new ArrayList<>());
        map.get(level).add(root.val);
        for(Node x:root.children){
            dfs(x,level+1);
        }
    }
}