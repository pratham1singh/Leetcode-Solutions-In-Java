class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n=arr.length,d=0;
        for(int x:arr)
            pq.add(-x);
        long ans=0;
        while(k>0){
            ans+=(-pq.poll()+d);
            d-=1;
            k-=1;
        }
        return ans;
    }
}