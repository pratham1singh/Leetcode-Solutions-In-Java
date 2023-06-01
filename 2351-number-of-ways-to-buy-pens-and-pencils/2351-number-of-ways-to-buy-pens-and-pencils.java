class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int a=Math.max(cost1,cost2);
        int b=Math.min(cost1,cost2);
        long ans=0;
        for(int i=0;i<=(total/a);i++){
           ans+=(total-a*i)/b+1;
        }
        if(ans==0)
            return 1;
        return ans;
    }
}