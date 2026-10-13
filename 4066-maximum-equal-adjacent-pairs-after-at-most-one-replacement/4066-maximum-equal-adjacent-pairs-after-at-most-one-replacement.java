class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length, i=0, mx=0;
        HashMap<String, Integer> map = new HashMap<>();

        while(i<n) {
            if(i-1>=0 && nums[i-1] != nums[i]) {
                String key = nums[i] + "->" + nums[i-1];
                map.put(key,map.getOrDefault(key, 0) + 1);

                if(mx<map.get(key)) mx = map.get(key);
            }
            if(i+1<n && nums[i+1] != nums[i]) {
                String key = nums[i] + "->" + nums[i+1];
                map.put(key,map.getOrDefault(key, 0) + 1);

                if(mx<map.get(key)) mx = map.get(key);
            }
            i++;
        }

        i=0;

        while(i<n-1) {
            if(nums[i] == nums[i+1]) mx++;
            i++;
        }

        return mx;
    }
}