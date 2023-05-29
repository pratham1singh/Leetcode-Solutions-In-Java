class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
        int n=nums.length,i=0;
        while(i<n-1){
            if(nums[i]!=nums[i+1])
                i+=1;
            else if(nums[i]==nums[i+1]&&map.get(nums[i])==null){
                map.put(nums[i],true);
                i+=1;
            }
            else{
                int k=i;
                while(k<n-1){
                    nums[k]=nums[k+1];
                    k+=1;
                }
                n-=1;
            }
        }
        return n;
    }
}