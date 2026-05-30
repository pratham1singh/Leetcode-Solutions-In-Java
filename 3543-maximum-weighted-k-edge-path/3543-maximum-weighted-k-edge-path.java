class Solution {
    int solved[][][];
    HashMap<Integer, ArrayList<int[]>> adj;

    static final int UNVISITED = Integer.MIN_VALUE + 1;

    public int find(int s, int count, int sum, int k, int t) {
        if (count == k) {
            if (sum < t) return sum;
            return Integer.MIN_VALUE;
        }

        if (sum >= t) return Integer.MIN_VALUE;

        if (solved[s][count][sum] != UNVISITED)
            return solved[s][count][sum];

        int ans = Integer.MIN_VALUE;

        for (int[] y : adj.get(s)) {
            int temp = find(y[0], count + 1, sum + y[1], k, t);
            ans = Math.max(ans, temp);
        }

        return solved[s][count][sum] = ans;
    }

    public int maxWeight(int n, int[][] edges, int k, int t) {
        adj = new HashMap<>();

        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for (int[] x : edges)
            adj.get(x[0]).add(new int[]{x[1], x[2]});

        solved = new int[n + 1][k + 1][t + 1];

        for (int[][] x : solved)
            for (int[] y : x)
                Arrays.fill(y, UNVISITED);

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, find(i, 0, 0, k, t));
        }

        return ans < 0 ? -1 : ans;
    }
}