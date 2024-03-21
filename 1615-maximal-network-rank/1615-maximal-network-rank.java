class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<Integer>());
        for(int x[]:roads){
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int visited[][]= new int[n][n],c=0;
                for(int a:map.get(i))
                    if(visited[i][a]==0){
                        visited[i][a]=1;
                        visited[a][i]=1;
                        c+=1;
                    }
                for(int a:map.get(j))
                    if(visited[j][a]==0){
                        visited[j][a]=1;
                        visited[a][j]=1;
                        c+=1;
                    }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}