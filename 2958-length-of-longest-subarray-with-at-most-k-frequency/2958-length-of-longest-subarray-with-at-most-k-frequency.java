class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.get(nums[i])!=null)
        //         map.put(nums[i],map.get(nums[i])+1);
        //     else
        //         map.put(nums[i],1);
        // }
        // System.out.println(map);
        int mx=0,c=0,i=0,n=nums.length;
        while(i<n){
            if(map.get(nums[i])==null||map.get(nums[i])<k){
                c+=1;
                if(map.get(nums[i])!=null)
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
                
                i+=1;
            }
            else{
                mx=Math.max(mx,c);
                c=1;
                i+=1;
            }
            // System.out.println(c);
        }
        return mx;
        
    }
}