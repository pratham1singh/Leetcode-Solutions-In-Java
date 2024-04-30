class Solution {
    int n,grid[][],solved[][][][];

    public int find(int a,int b,int p,int q){
        if(a==n-1&&b==n-1&&p==n-1&&q==n-1)
            return 0;
        else if(solved[a][b][p][q]!=-1)
            return solved[a][b][p][q];
        else{
            int ans=Integer.MIN_VALUE;
            if(a+1<n&&p+1<n&&grid[a+1][b]!=-1&&grid[p+1][q]!=-1)
                ans=Math.max(ans,((a+1==p+1&&b==q)?grid[a+1][b]:(grid[a+1][b]+grid[p+1][q]))+find(a+1,b,p+1,q));

            if(a+1<n&&q+1<n&&grid[a+1][b]!=-1&&grid[p][q+1]!=-1)
                ans=Math.max(ans,((a+1==p&&b==q+1)?grid[a+1][b]:(grid[a+1][b]+grid[p][q+1]))+find(a+1,b,p,q+1));

            if(p+1<n&&b+1<n&&grid[a][b+1]!=-1&&grid[p+1][q]!=-1)
                ans=Math.max(ans,((a==p+1&&b+1==q)?grid[a][b+1]:(grid[a][b+1]+grid[p+1][q]))+find(a,b+1,p+1,q));

            if(q+1<n&&b+1<n&&grid[a][b+1]!=-1&&grid[p][q+1]!=-1)
                ans=Math.max(ans,((a==p&&b+1==q+1)?grid[a][b+1]:(grid[a][b+1]+grid[p][q+1]))+find(a,b+1,p,q+1));
            // if(ans>0)
            // System.out.println(a+" "+b+" "+p+" "+q+" "+ans);
            return solved[a][b][p][q]=ans;
  }
}
    public int cherryPickup(int[][] grid) {
        this.grid=grid;
        n=grid.length;
        solved= new int[n][n][n][n];
        for(int x[][][]:solved)
            for(int y[][]:x)
                for(int z[]:y)
                    Arrays.fill(z,-1);

        int ans=find(0,0,0,0);
        
        return ans<0?0:grid[0][0]+ans;
    }
}