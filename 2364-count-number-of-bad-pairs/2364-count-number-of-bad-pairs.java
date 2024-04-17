class Solution {
    public long countBadPairs(int[] nums) {
         int n=nums.length;
         long ans=0;
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            nums[i]-=i;
            map.put(nums[i],0);
        }
        for(int i=n-1;i>=0;i--){
            ans=(ans+n-i-1-map.get(nums[i]));
            map.put(nums[i],map.get(nums[i])+1);
        }
        return ans;
    }
}