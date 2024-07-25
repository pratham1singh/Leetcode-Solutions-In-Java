class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length,i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x:nums)
            pq.add(x);

        while(pq.size()>0)
            nums[i++]= pq.poll();
        return nums;

    }
}