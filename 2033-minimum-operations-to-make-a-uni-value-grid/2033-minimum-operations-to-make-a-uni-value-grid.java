class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = grid[0].length * grid.length;

        for(int[] arr1: grid) 
            for(int y: arr1) {
                if(y%x!=grid[0][0]%x) return -1;
                arr.add(y);
            }

        Collections.sort(arr);

        for(int i = 1; i<n; i++) arr.set(i, arr.get(i-1) + arr.get(i));

        int ans  = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++) {
            int left_sum = i -1 >=0 ? arr.get(i-1) : 0;
            int right_sum = arr.get(n-1) - arr.get(i);
            int crr = arr.get(i) - left_sum;

            if((crr*i - left_sum)  % x == 0 && (right_sum - crr * (n-i -1)) % x == 0 ) {
                ans = Math.min(ans, (crr*i - left_sum) / x + (right_sum - crr * (n-i -1)) / x);
            }

        }

        return ans;
    }
}