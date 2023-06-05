class Solution {
    HashMap<Integer,ArrayList<Integer>>list=new HashMap<>();
    HashMap<Integer,Boolean>blocked=new HashMap<>();
    int ans=0;
    public void find(Queue<Integer> queue){
        int l=1;
        blocked.put(0,true);
        while(l>0){
            int x=queue.remove();
            l-=1;
            ans+=1;
            for(Integer a:list.get(x)){
                if(blocked.get(a)==null){
                    queue.add(a);
                    blocked.put(a,true);
                    l+=1;
                }
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int i=0;i<n;i++){
            list.put(i,new ArrayList<Integer>());
        }
        for(int x[]:edges){
            list.get(x[0]).add(x[1]);
            list.get(x[1]).add(x[0]);
        }
        for(Integer x:restricted){
            blocked.put(x,true);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        find(queue);
        return ans;
        
    }
}