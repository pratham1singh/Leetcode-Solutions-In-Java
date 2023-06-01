class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=grid.length;
        for(int i=0;i<n;i++){
            String str="";
            for(int j=0;j<n;j++){
                str+=grid[i][j]+"+";
            }
            if(map.get(str)!=null)
                map.put(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        int ans=0;
        for(int j=0;j<n;j++){
            String str="";
            for(int i=0;i<n;i++){
                str+=grid[i][j]+"+";
            }
            if(map.get(str)!=null)
                ans+=map.get(str);
        }
        return ans;

    }
}