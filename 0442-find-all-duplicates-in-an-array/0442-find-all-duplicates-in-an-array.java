class Solution {
    
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null)
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        ArrayList<Integer> ans =new  ArrayList<Integer>();
        for(Integer x:map.keySet()){
            if(map.get(x)==2)
                ans.add(x);
        }
        return ans;
    }
}