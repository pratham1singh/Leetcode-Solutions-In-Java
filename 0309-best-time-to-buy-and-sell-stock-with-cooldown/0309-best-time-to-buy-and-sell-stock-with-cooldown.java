class Solution {
    int n,prices[],solved[][];
    public  int find(int i,int j){
        if(i>=n)
            return 0;
        else if(j==-1)
            return Math.max(find(i+1,i),find(i+1,j));
        else if(solved[i][j]!=-1)
            return solved[i][j];
        else if(prices[j]<prices[i]){
            return solved[i][j]=Math.max(prices[i]-prices[j]+find(i+2,-1),find(i+1,j));
        }
        else
            return solved[i][j]=find(i+1,j);
    }
    public int maxProfit(int[] prices) {
        n=prices.length;
        this.prices=prices;
        solved= new int[n][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        return find(0,-1);
    }
}