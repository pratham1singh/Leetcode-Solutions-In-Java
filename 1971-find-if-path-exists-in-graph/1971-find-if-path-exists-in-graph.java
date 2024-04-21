class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    int visited[],solved[];
    public boolean isPath(int source,int dist){
        if(source==dist)
            return true;
        if(solved[source]!=0)
            return solved[source]==1;
        boolean ans=false;
        for(int x:map.get(source))
            if(visited[x]==0){
                visited[x]=1;
                ans=ans||isPath(x,dist);
                visited[x]=0;
            }
        solved[source]=ans?1:-1;
        return ans;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited= new int[n];
        visited[source]=1;
        solved= new int[n];
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<Integer>());
        for(int x[]:edges){
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        return isPath(source,destination);
    }
}