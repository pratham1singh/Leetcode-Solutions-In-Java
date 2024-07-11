class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length,mn=Math.abs(matrix[0][0]),flag=0;
        long sum=0;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);
                mn=Math.min(mn,Math.abs(matrix[i][j]));
                
            }
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(matrix[i][j]<0)
                    flag+=1;
        return flag%2==0?sum:sum-2*mn;
    }
}