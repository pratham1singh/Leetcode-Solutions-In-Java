class Solution {
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
    int solved[][];

    public boolean find(int src,int dest){
        if(src==dest) return true;
        if(solved[src][dest]!=-1) return solved[src][dest]==1;
        boolean ans=false;
        for(int a:adj.get(src))
            ans=ans || find(a,dest);
        solved[src][dest]=ans?1:0;
        return ans;
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<Integer>());
            
        solved= new int[n][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);

        for(int x[]:prerequisites)
            adj.get(x[0]).add(x[1]);
        List<Boolean> ans = new ArrayList<>();

        for(int x[]:queries)
            ans.add(find(x[0],x[1]));

        return ans;
    }
}