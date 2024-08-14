class Solution {
    HashMap<Integer,Integer> children= new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> adj= new HashMap<>();
    int visited[];

    public int countChildren(int root){
        int ans=0;
        visited[root]=1;
        for(int x:adj.get(root))
            if(visited[x]==0)
                ans+=countChildren(x);
        visited[root]=0;
        children.put(root,ans+1);
        return ans+1;
    }
    public int countGoodNodes(int root){
       int ans=0;
       HashSet<Integer> set = new HashSet<>();
       visited[root]=1;
       for(int x:adj.get(root))
            if(visited[x]==0){
                ans+=countGoodNodes(x);
                set.add(children.get(x));
            }
       visited[root]=0;
       return (set.size()<=1?1:0)+ans;
       
    }
    public int countGoodNodes(int[][] edges) {
        int n=edges.length+1;
        visited= new int[n];
        for(int i=0;i<n;i++)
            adj.put(i, new ArrayList<>());

        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        countChildren(0);
        return countGoodNodes(0);
    }
}