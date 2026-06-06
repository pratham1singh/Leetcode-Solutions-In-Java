class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size(), width = 0, ans =Integer.MIN_VALUE;

        for(List<Integer> list: wall) {
            width = Math.max(width, list.size());
            for(int i=1;i<list.size();i++) list.set(i, list.get(i-1)+list.get(i));
        }
            HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> list: wall) {
            for(int i=0;i<list.size()-1; i++) {
                map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
                ans=Math.max(ans, map.get(list.get(i)));
            }
        }

        return ans == Integer.MIN_VALUE ? n : n-ans;
    }
}