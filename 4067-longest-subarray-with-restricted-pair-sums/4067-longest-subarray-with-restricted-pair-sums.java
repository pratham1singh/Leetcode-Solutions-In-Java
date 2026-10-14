class Solution {

    private boolean isValid(int[] nums, int i, int j, int x, int[] arr) {
        int temp = i;

        while(i<=j) {
            if(Math.abs(x-nums[i]) == nums[i] ? arr[Math.abs(x-nums[i])]>1 :  arr[Math.abs(x-nums[i])]>0) return false;
            i++;
        }
        return true;
    }

    public int maxSubarray(int[] nums) {
        int n = nums.length, i=0,j=0, ans=0;
        int[] arr = new int[1001];

        while(j<n) {
            if(isValid(nums, i,j-1,nums[j],arr)) arr[nums[j]]++;
            else {
                while(i<j && !isValid(nums, i,j-1,nums[j], arr)) {
                    arr[nums[i]]--;
                    i++;
                }
                arr[nums[j]]++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;
    }
}