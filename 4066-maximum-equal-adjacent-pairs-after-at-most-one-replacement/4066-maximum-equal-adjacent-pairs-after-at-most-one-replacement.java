class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length, i=0, mx=0, temp=0;
        HashMap<String, Integer> map = new HashMap<>();

        while(i<n) {
          
            if(i-1>=0 && nums[i-1] != nums[i]) map.put(nums[i] + "->" + nums[i-1],map.getOrDefault(nums[i] + "->" + nums[i-1], 0) + 1);
            if(i+1<n && nums[i+1] != nums[i]) map.put(nums[i] + "->" + nums[i+1],map.getOrDefault(nums[i] + "->" + nums[i+1], 0) + 1);

            i++;
        }


        i=0;

        while(i<n-1) {
            if(nums[i] == nums[i+1]) temp++;
            i++;
        }

        for(int x: map.values()) if(x>mx) mx = x;

    return temp + mx;


    }
}