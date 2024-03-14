class Solution {
    int n;
    double solved[][][];

    public double possible(int i,int j,int k){
        // System.out.println("a");
        if(i>=n||j>=n||i<0||j<0)
            return 0;
        else if(k==0)
            return 1;
        else if(solved[i][j][k]!=-1)
            return solved[i][j][k];
        else{
            double ans=0;
            ans+=possible(i+2,j+1,k-1);
            ans+=possible(i+2,j-1,k-1);
            ans+=possible(i-2,j+1,k-1);
            ans+=possible(i-2,j-1,k-1);
            ans+=possible(i+1,j+2,k-1);
            ans+=possible(i-1,j+2,k-1);
            ans+=possible(i+1,j-2,k-1);
            ans+=possible(i-1,j-2,k-1);
            return solved[i][j][k]=ans;
        }
    }
    
    public double knightProbability(int n, int k, int row, int column) {
        this.n=n;
        solved= new double[n][n][k+1];
        for(double a[][]:solved)
            for(double b[]:a)
                Arrays.fill(b,-1);
        double possible = possible(row,column,k);

        return possible/Math.pow(8,k);
    }
}