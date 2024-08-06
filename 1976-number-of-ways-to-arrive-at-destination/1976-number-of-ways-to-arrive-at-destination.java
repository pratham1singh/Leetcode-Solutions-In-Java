class Solution {
    int n,roads[][],weight[][];
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

    public int shortestDist(int src,int dest){
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(src);
        while(pq.size()>0){
            int z=pq.poll();
            for(int a:adj.get(z))
                if(dist[z]+weight[z][a]<dist[a]){
                    dist[a]=dist[z]+weight[z][a];
                    pq.add(a);
                }
        }
        return dist[dest];

    }
    public int count(int src,int dest,int cost){
        if(src==dest&&cost==0)
            return 1;
        else if(cost<=0)
            return 0;
        else{
            int ans=0;
            for(int a:adj.get(src))
                ans+=count(a,dest,cost-weight[src][a]);
            return ans;
        }
    }
    public int countPaths(int n, int[][] roads) {
        this.roads=roads;
        this.n=n;
        weight= new int[n][n];
        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<>());

        for(int x[]:roads){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            weight[x[0]][x[1]]=x[2];
            weight[x[1]][x[0]]=x[2];
        }
        int mn=shortestDist(0,n-1);
        // System.out.println(mn);
        return count(0,n-1,mn);
    }
}