class Solution {
    int n,coins[],visited[][];
    public int count(int i,int target){
        if(target==0)
            return 0;
        else if(i>=n||target<0)
            return 100000;
        else if(visited[i][target]!=0)
            return visited[i][target];
        else{
            int without=count(i+1,target);
            int with= 1+count(i,target-coins[i]);
            visited[i][target]=Math.min(without,with);
            return visited[i][target];
        }
    }
    public int coinChange(int[] coins, int amount) {
        this.n=coins.length;
        this.coins=coins;
        this.visited= new int[n+1][amount+1];
        int ans=count(0,amount);
        return ans>amount?-1:ans;
    }
}