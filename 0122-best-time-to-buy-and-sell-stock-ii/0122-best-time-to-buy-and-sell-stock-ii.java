class Solution {
    int n,prices[],solved[];
    public int find(int i){
        if(i==n)
            return 0;
        else if(solved[i]!=-1)
            return solved[i];
        else{
            int ans=0;
            for(int j=i+1;j<n;j++)
                if(prices[j]>prices[i])
                    ans=Math.max(ans,prices[j]-prices[i]+find(j+1));
            return solved[i]=Math.max(ans,find(i+1));
        }
    }
    public int maxProfit(int[] prices) {
        n=prices.length;
        this.prices=prices;
        solved= new int[n];
        Arrays.fill(solved,-1);
        return find(0);
    }
}