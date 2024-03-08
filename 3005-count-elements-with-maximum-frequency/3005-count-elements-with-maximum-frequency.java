class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length,mx=0,ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:nums)
            if(map.get(x)!=null)
                map.put(x,map.get(x)+1);
            else
                map.put(x,1);
        for(int x:map.values())
            mx=Math.max(mx,x);
        for(int x:map.values())
            if(x==mx)
                ans+=x;
        return ans;
         
    }
}