class Solution {
    public int fac(int n){
        if(n<=1)
            return 1;
        else
            return n*fac(n-1);
    }
    ArrayList<String> ans = new ArrayList<>();
    int n;
    public void find(int i,char ch,String s){
        if(i==n)
            ans.add(s);
        else{
            for(char k='a';k<='c';k++)
                if(k!=ch)
                    find(i+1,k,s+k);
                
        }
    }
    public String getHappyString(int n, int k) {
        this.n=n;
        find(0,'.',"");
        if(ans.size()<=k-1)
            return "";
        
        return ans.get(k-1);
    }
}