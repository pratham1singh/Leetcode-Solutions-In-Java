class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(Integer x: nums){
            if(map.get(x)!=null){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        int ans=0;
        for(Integer x:map.keySet()){
            if(map.get(x)==1)
                ans+=x;
        }
        return ans;
    }
}