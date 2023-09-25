class node{
    int s;
    List<Integer> list1;
    public node(int s){
        this.s=s;
        this.list1 =new ArrayList<>();
        list1.add(s);
    }
    public node(int s,List<Integer> l){
        this.s=s;
        this.list1 =new ArrayList<>(l);
        list1.add(s);
    }
}
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans =new ArrayList<>();
        int n=graph.length;
        Queue<node> queue =new LinkedList<>();
        queue.add(new node(0));
        int l=1;
        while(l>0){
            node x= queue.poll();
            l-=1;
            if(x.s==n-1)
                ans.add(x.list1);
            else{
                for(int a:graph[x.s]){
                    queue.add(new node(a,x.list1));
                    l+=1;
                }
            }
        }
        return ans;
    }
}