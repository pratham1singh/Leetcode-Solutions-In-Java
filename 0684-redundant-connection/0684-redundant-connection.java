class Solution {
    HashMap<Integer,HashMap<Integer,Boolean>> adj = new HashMap<>();
    int n;
    public boolean isConnected(int node){
        int visited[]= new int[n+1],c=0;
        visited[node]=1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(queue.size()>0){
            int x=queue.remove();
            c+=1;
            for(int a:adj.get(x).keySet())
                if(visited[a]==0){
                    visited[a]=1;
                    queue.add(a);
                }
        }
        return c==n;
    }
    public int[] findRedundantConnection(int[][] edges) {
        n=edges.length;
        for(int i=1;i<=n;i++)
            adj.put(i,new HashMap<>());
        for(int x[]:edges){
            adj.get(x[0]).put(x[1],true);
            adj.get(x[1]).put(x[0],true);
        }
        for(int i=n-1;i>=0;i--){
            adj.get(edges[i][0]).remove(edges[i][1]);
            adj.get(edges[i][1]).remove(edges[i][0]);
            if(isConnected(edges[i][0]))
                return edges[i];
            adj.get(edges[i][0]).put(edges[i][1],true);
            adj.get(edges[i][1]).put(edges[i][0],true);
        }
        return new int[2];
    }
}