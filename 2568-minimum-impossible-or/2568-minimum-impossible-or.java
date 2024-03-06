class Solution {

    public int minImpossibleOR(int[] nums) {
        HashMap<Integer,Boolean> map =  new HashMap<>(); 
        int n=nums.length,mn=nums[0],mx=0;
        for(int i=0;i<n;i++){
            if(nums[i]<mn)
                mn=nums[i];
            if(nums[mx]<nums[i])
                mx=i;
            map.put(nums[i],true);
        }
        if(mn>1)
            return 1;
        int ans=nums[mx],c=0;
        while(nums[mx]>0){
            int flag=1;
            for(int i=0;i<n;i++)
                if((nums[i]&1)==1){
                    flag=-1;
                    break;
                }
            if(flag==1)
                return (int)Math.pow(2,c);
            else if(map.get((int)Math.pow(2,c))==null)
                return (int)Math.pow(2,c);
            for(int i=0;i<n;i++)
                nums[i]=nums[i]>>1;
            c+=1;
        }
        return (int)Math.pow(2,c);
    }
}