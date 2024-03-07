class Solution {
    int n,visited[][],palin[][];
    String s;

    public boolean isPalin(int i,int j){
        if(i>=j)
            return true;
        else if(palin[i][j]!=0)
            return palin[i][j]==1?true:false;
        else{
            boolean ans=(s.charAt(i)==s.charAt(j))&&isPalin(i+1,j-1);
            palin[i][j]=ans?1:-1;
            return ans;
        }
    }
    public boolean find(int i,int k){
        if(i==n&&k==0)
            return true;
        
        else if(visited[i][k]!=-1)
            return visited[i][k]==1;
        else if(i<n&&k==1)
            return isPalin(i,n-1);
        else{
            boolean ans=false;
            for(int j=i;j<n;j++){
                if(isPalin(i,j)){
                    ans=ans||find(j+1,k-1);
                }
            }
            visited[i][k]=ans?1:0;
            return ans;
        }
    }
    public boolean checkPartitioning(String s) {
        n=s.length();
        visited= new int[n+1][n+1];
        palin= new int[n+1][n+1];
        for(int x[]:visited)
            Arrays.fill(x,-1);
            

        this.s=s;
        return find(0,3);
    }
}