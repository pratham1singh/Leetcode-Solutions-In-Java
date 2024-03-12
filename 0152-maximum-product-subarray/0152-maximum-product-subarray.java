class Solution {
    int n,nums[];
    HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
    public int find(int i,int p){
        if(i==n)
            return p;
        else if(map.get(i).get(p)!=null)
            return map.get(i).get(p);
        else{
            int a=find(i+1,p*nums[i]);
            map.get(i).put(p,Math.max(a,p));
            return map.get(i).get(p);
        }
    }
    public int maxProduct(int[] nums) {
        n=nums.length;
        this.nums=nums;
        int k=1;
        for(int x:nums)
            if(x>0)
                k*=x;
        for(int i=0;i<n;i++)
            map.put(i,new HashMap<Integer,Integer>());
        int ans=find(1,nums[0]);
        for(int i=1;i<n;i++)
            ans=Math.max(ans,find(i+1,nums[i]));
        
        return ans;
    }
}