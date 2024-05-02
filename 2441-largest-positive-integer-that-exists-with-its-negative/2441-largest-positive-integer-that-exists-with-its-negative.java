class Solution {
    public int findMaxK(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int x:nums)
            map.put(x,true);
        int ans=-1;
        for(int x:nums)
            if(x>ans&&map.get(-x)!=null)
                ans=x;
        return ans;
    }
}