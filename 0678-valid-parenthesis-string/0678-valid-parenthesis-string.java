class Solution {
    int n,solved[][][];
    String s;

    public boolean check(int i,int open,int close){
        if(i==n)
            return open==0&&close==0;
        else if(solved[i][open][close]!=0)
            return solved[i][open][close]==1?true:false;
        boolean ans=false;
        if(s.charAt(i)=='(')
            ans=ans|| check(i+1,open+1,close);
        else if(s.charAt(i)=='*'&&open>0)
            ans=ans|| check(i+1,open-1,close)||check(i+1,open+1,close)||check(i+1,open,close);
        else if(s.charAt(i)=='*')
            ans=ans|| check(i+1,open+1,close)||check(i+1,open,close);
        else
            ans=ans|| open>0&&check(i+1,open-1,close);
        solved[i][open][close]=(ans?1:-1);
        return ans;
    }
    public boolean checkValidString(String s) {
        n=s.length();
        this.s=s;
        solved= new int[100][100][100];
        return check(0,0,0);
    }
}