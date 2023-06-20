class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int row[]= new int[m];
        int col[] =new int[n];
        for(int i=0;i<m;i++){
            int s=0;
            for(int j=0;j<n;j++){
                s+=grid[i][j];
                if(s>1)
                    break;
            }
            if(s>1){
                row[i]=1;
            }
        }
        for(int j=0;j<n;j++){
            int s=0;
            for(int i=0;i<m;i++){
                s+=grid[i][j];
                if(s>1)
                    break;
            }
            if(s>1){
                col[j]=1;
            }
        }
        int ans=0;
        // for(int i=0;i<m;i++){
        //    System.out.print(row[i]+" ");
        // }
        //  System.out.println(" ");
        //  for(int j=0;j<n;j++){
        //        System.out.print(col[j]+" ");
        //     }
           
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&(row[i]==1||col[j]==1))
                    ans+=1;
            }
        }
        return ans;
    }
}