class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(Integer x:nums){
            if(map.get(k-x)!=null&&map.get(k-x)>0){
                map.put(k-x,map.get(k-x)-1);
                ans+=1;
            }
            else if(map.get(x)!=null)
                 map.put(x,map.get(x)+1);
            else
                map.put(x,1);
                
        }
        return ans;
    }
}