class Solution {
    HashMap<Integer,Integer> map= new HashMap<>();
    int visited[],ans=-1,edges[];

    public void find(int i,int ind){
        if(i==-1)
            return ;
        if(map.get(i)!=null)
            ans=Math.max(ans,ind-map.get(i));
        else if(visited[i]==1)
            return ;
        else{
            map.put(i,ind);
            visited[i]=1;
            find(edges[i],ind+1);
            map.remove(i);
        }
    }
    public int longestCycle(int[] edges) {
       int n=edges.length;
       visited= new int[n];
        this.edges=edges;

        for(int i=0;i<n;i++)
            if(visited[i]==0){
                find(i,0);
            }
        if(ans==-1) return -1;
        return ans;
    }
}