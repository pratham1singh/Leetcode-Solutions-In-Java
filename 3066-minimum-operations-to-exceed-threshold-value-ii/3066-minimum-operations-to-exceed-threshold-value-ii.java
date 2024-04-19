class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length,ans=0;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int x:nums)
            pq.add(x);
        while(pq.size()>1&&pq.peek()<k){
            int x=pq.poll(),y=pq.poll();
            pq.add(Math.min(x,y)*2+Math.max(x,y));
            ans+=1;
        }
        return ans;
    }
}