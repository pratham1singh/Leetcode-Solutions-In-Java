class Solution {
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
    int values[],visited[];

    public long sum_to_leave(int node){
        
        
            int flag=0;
            long ans=Integer.MAX_VALUE;
            for(int a:adj.get(node)){
                 if(visited[a]==0){
                        if(flag==0){
                    ans=0;
                    flag=1;
                }
                        visited[a]=1;
                        ans+=sum_to_leave(a);
                    }
            }
            // System.out.println(values[node]+" "+ans);
            return Math.min(ans,values[node]);
        
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        this.values=values;
        int n=edges.length+1;
        long sum=0;
        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<Integer>());
        
        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        visited= new int[n];
        visited[0]=1;
        for(int x:values)
            sum+=x;

        return sum-sum_to_leave(0);
    }
}