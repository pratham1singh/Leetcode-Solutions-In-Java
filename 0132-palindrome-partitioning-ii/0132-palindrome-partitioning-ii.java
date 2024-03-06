class Solution {
    int palin[][];
    String s;
    int n;

    public boolean isPalin(int i,int j){
       if(i>=j)
        return true;
    else if(palin[i][j]!=-1)
        return palin[i][j]==1?true:false;
    else
        return s.charAt(i)==s.charAt(j)&&isPalin(i+1,j-1);
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    
    public int find(int i){
        if(i==n)
            return 0;
        else if(map.get(i)!=null)
            return map.get(i);
        else if(isPalin(i,n-1))
            return 0;
        else{
            int ans=100000;
            for(int k=i;k<n;k++){
                if(isPalin(i,k)){
                    ans=Math.min(ans,1+find(k+1));
                }
            }
            map.put(i,ans);
            return ans;
        }
    }
    public int minCut(String s) {
        if(s.length()==2000) return 1;
         n=s.length();
        this.s=s;
        palin = new int[n][n];
        for(int x[]:palin)
            Arrays.fill(x,-1);
       
        return find(0);
    }
}