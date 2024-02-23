class Solution {
    int arr[][],n,k,visited[][],solved[][];
    HashMap<Integer,ArrayList<Integer>> map =new HashMap<>();
    public int find(int s,int d,int c){
        // System.out.println(s+" "+c);
        if(s==d)
            return 0;
        else if(c>k)
            return 100000000;
        else if(solved[s][c]!=-1)
            return solved[s][c];
        else{
            int ans=100000000;
            for(int a:map.get(s)){
                if(visited[s][a]==0){
                    visited[s][a]=1;
                    ans=Math.min(ans,arr[s][a]+find(a,d,c+1));
                    visited[s][a]=0;
                }
            }
            return solved[s][c]=ans;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.n=n;
        this.k=k;
        visited= new int[n][n];
        arr= new int[n][n];
        solved= new int[n][k+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=k;j++)
                solved[i][j]=-1;
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<Integer>());
        for(int x[]:flights){
            arr[x[0]][x[1]]=x[2];
            map.get(x[0]).add(x[1]);
        }
        
        int ans=find(src,dst,0);
        return ans==100000000?-1:ans;
        
    }
}