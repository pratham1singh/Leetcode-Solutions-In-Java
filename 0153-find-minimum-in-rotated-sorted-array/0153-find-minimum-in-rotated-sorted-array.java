class Solution {

    
    public int findMin(int[] nums) {
        
        int n=nums.length,i=0,f=n-1,m=(int)(i+f)/2;
        while(i<f){
            
            if(nums[m]<nums[f])
                f=m;
            else
                if(i==m)
                    i=m+1;
                else
                    i=m;
            m=(int)(i+f)/2;
        }
        if(i==0)
            return nums[0];
        return nums[m];
        
    }
}