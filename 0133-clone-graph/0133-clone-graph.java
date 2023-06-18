/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if(node==null)
                return  null;
        if(node.neighbors.size()==0)
            return new Node(node.val);
            
        
        
        HashMap<Integer,Node> map =new HashMap<>();
        HashMap<Integer,List<Node>> list =new HashMap<>();
        Queue<Node> queue= new LinkedList<>();
        queue.add(node);
        int l=1;
        map.put(node.val,new Node(node.val));
        while(l>0){
            
            Node x = queue.remove();
            list.put(x.val,x.neighbors);
            l-=1;
            
            for(Node a: x.neighbors){
                
                if(map.get(a.val)==null){
                       
                     Node n = new Node(a.val);
                    map.put(a.val,n);
                   
                    queue.add(a);
                    l+=1;
                }
            }
           
        }
        for(Integer x:map.keySet()){
            List<Node> nlist= new ArrayList<Node>();
            for(Node a:list.get(x)){
                nlist.add(map.get(a.val));
            }
            map.get(x).neighbors= nlist;
        }

       
        return map.get(node.val);

    }
}

