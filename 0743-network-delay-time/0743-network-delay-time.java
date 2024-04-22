class edge{
    int u,v,t;
    public edge(int u,int v,int t){
        this.u=u;
        this.v=v;
        this.t=t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++)
            adj.put(i,new HashMap<Integer,Integer>());
        for(int x[]:times)
            adj.get(x[0]-1).put(x[1]-1,x[2]);
        int ans[]= new int[n],visited[][]= new int[n][n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k-1]=0;
        PriorityQueue<edge> pq = new PriorityQueue<>((a,b)->{
            return a.t-b.t;
        });
        for(int x:adj.get(k-1).keySet()){
            pq.add(new edge(k-1,x,adj.get(k-1).get(x)));
            visited[k-1][x]=1;
        }
        
        while(pq.size()>0){
            edge z=pq.poll();
            ans[z.v]=Math.min(ans[z.v],z.t);

            for(int x:adj.get(z.v).keySet())
                if(visited[z.v][x]==0){
                    visited[z.v][x]=1;
                    pq.add(new edge(z.v,x,z.t+adj.get(z.v).get(x)));
                    
                }

        }
        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
        int c=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++)
        for(int i=0;i<n;i++)
            if(i!=k-1&&c<ans[i])
                c=ans[i];
        if(c==Integer.MAX_VALUE)
            return -1;
        return c;
    }
}