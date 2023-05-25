class Solution {
    
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        ArrayList<Integer> ans =new  ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null)
                ans.add(nums[i]);
            else
                map.put(nums[i],1);
        }
        
        
        return ans;
    }
}