class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length, x = 0;
        if(n%k !=0) return false;

        x= n/k;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int z: nums)
            map.put(z, map.getOrDefault(z,0) +1);
        for(int z: map.values())
            if(z > x) return false;

        return true;
    }
}