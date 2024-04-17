class Solution {
    public int rev(int x){
        int ans=0;
        while(x>0){
            ans=ans*10+x%10;
            x/=10;
        }
        return ans;
    }
    public int countNicePairs(int[] nums) {
        int n=nums.length,ans=0,M=(int)Math.pow(10,9)+7;
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            nums[i]-=rev(nums[i]);
            map.put(nums[i],0);
        }
        for(int i=n-1;i>=0;i--){
            ans=(ans+map.get(nums[i]))%M;
            map.put(nums[i],map.get(nums[i])+1);
        }
        return ans%M;

    }
}