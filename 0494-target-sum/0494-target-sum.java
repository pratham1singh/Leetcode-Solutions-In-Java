class Solution {
    int n,nums[],target;
    HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
    public int count(int i,int val){
        if(val==target&&i==n)
            return 1;
        else if(i>=n)
            return 0;
        else if(map.get(i)!=null&&map.get(i).get(val)!=null)
            return map.get(i).get(val);
        else{
            int ans=count(i+1,val+nums[i])+count(i+1,val-nums[i]);
            if(map.get(i)!=null)
                map.get(i).put(val,ans);
            else{
                HashMap<Integer,Integer> map2 = new HashMap<>();
                map2.put(val,ans);
                map.put(i,map2);
            }
            return map.get(i).get(val);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.n=nums.length;
        this.nums=nums;
        this.target=target;
        return count(0,0);
    }
}