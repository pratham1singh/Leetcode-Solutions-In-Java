class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int count(int i){
        if(map.get(i).size()==0)
            return 0;
        else{
            int c=0;
            for(int a:map.get(i))
                c=c+1+count(a);
            return c;
        }
    }
    public int findChampion(int n, int[][] edges) {
        
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<Integer>());
        for(int x[]:edges)
            map.get(x[0]).add(x[1]);
        int ans=-1;
        for(int i=0;i<n;i++){
            int c=count(i);
            if(c==n-1){
                if(ans==-1)
                    ans=i;
                else
                    return -1;
            }
        }
        return ans;
    }
}