class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> st = new Stack<>();

        for(int[] y: intervals ) {
            if(st.size() ==0) st.add(y);
            else {
                int[] x = st.peek();
                if(x[1] < y[0]) st.add(y);
                else {
                    x[1] = Math.max(x[1], y[1]);
                }
            }
        }
       int[][] ans = new int[st.size()][2];
       int i =0;
       for(int[] a: st) ans[i++] = a;
       return ans;

    }
}