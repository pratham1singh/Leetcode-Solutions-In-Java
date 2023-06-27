class Solution {
    public int matrixSum(int[][] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int r=nums.length,c=nums[0].length;
       
        for(int i=0;i<r;i++){
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for(int j=0;j<c;j++){
                queue.add(nums[i][j]);
            }
            map.put(i,queue);
        }
        int ans=0;
        for(int j=0;j<c;j++){
            int mx=0;
            for(int i=0;i<r;i++){
                mx=Math.max(mx,map.get(i).poll());
            }
            ans+=mx;
        }
        return ans;
    }
}