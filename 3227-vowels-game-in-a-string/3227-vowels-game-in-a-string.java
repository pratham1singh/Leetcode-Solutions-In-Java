class Solution {

    //flag==1 
    int visited[][];
    public boolean find(int n,int flag){
        if(n==0&&flag==1)
            return false;
        if(n==0)
            return true;
        if(n%2==0&&flag==0)
            return false;
        if(n%2!=0&&flag==1)
            return true;
        if(visited[n][flag]!=-1)
            return visited[n][flag]==1;
        if(flag==1){
            boolean ans=false;
            for(int k=1;k<=n;k+=2)
                ans=ans || find(n-k,0);
            visited[n][flag]=(ans?1:0);
            return ans;
        }
        else{
            boolean ans=true;
            for(int k=2;k<=n;k+=2)
                ans=ans&&find(n-k,1);
            visited[n][flag]=(ans?1:0);
            return ans;
        }

    }
    public boolean doesAliceWin(String s) {
        int n=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
                n++;
        visited= new int[n+1][2];
        for(int x[]:visited)
            Arrays.fill(x,-1);

        return find(n,1);
    }
}