class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, ArrayList<Long>> map = new HashMap<>();

        for(int i=0;i<n;i++) map.computeIfAbsent(nums[i], k -> new ArrayList<Long>()).add((long)i);
        for(ArrayList<Long> arr: map.values()) {
            int m = arr.size();
            for(int i=1;i<m;i++) arr.set(i, arr.get(i) + arr.get(i-1));

            for(int i=0;i<m;i++) {
                long left = i-1>=0 ? arr.get(i-1) : 0L;
                long right = arr.get(m-1) - arr.get(i);
                long crr = arr.get(i) - left;

                ans[(int)crr] =  (crr*i - left) + (right - crr*(m-i-1));
            }
        }

        return ans;
    }
}