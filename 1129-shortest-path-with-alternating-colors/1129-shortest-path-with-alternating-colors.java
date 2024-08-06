class Solution {
    int visited[],n;
    HashMap<Integer,ArrayList<Integer>> redEdges = new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> blueEdges = new HashMap<>();

    public int dist(int a,int b,int col){
        if(a==b)
            return 0;
        //0-> red
        if(col==0){
            int ans=1000000;
            for(int x:redEdges.get(a))
                if(visited[x]==0){
                    visited[x]=1;
                    ans=Math.min(ans,1+dist(x,b,1));
                    visited[x]=0;
                }
            return ans;
        }
        else{
            int ans=1000000;
            for(int x:blueEdges.get(a))
                if(visited[x]==0){
                    visited[x]=1;
                    ans=Math.min(ans,1+dist(x,b,0));
                    visited[x]=0;
                }
            return ans;
        }

    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        this.n=n;
        for(int i=0;i<n;i++){
            this.redEdges.put(i,new ArrayList<>());
            this.blueEdges.put(i,new ArrayList<>());
        }
        for(int x[]:redEdges)
            this.redEdges.get(x[0]).add(x[1]);
        for(int x[]:blueEdges)
            this.blueEdges.get(x[0]).add(x[1]);
        int ans[]= new int[n];
        visited= new int[n];
        visited[0]=1;
        for(int i=0;i<n;i++){
            ans[i]=Math.min(dist(0,i,0),dist(0,i,1));
            if(ans[i]==1000000)
                ans[i]=-1;
        }
        return ans;
    }
}