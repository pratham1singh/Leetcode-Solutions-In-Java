class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length==1&&nums[0]==0)
            return 0;
        ArrayList<Integer> list1 = new ArrayList<>();

        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(c!=0)
                list1.add(c);
                list1.add(0);
                c=0;
            }
            else
                c+=1;
        }
        if(c!=0)
            list1.add(c);
        int ans=0,n=list1.size();
        if(n==1){
            return list1.get(0)-1;
        }
       for(int i=0;i<n;i++){
           int k=0;
           if(i-1>=0)
            k+=list1.get(i-1);
            if(i+1<n)
                k+=list1.get(i+1);
            ans=Math.max(ans,k);
       }

        return ans;
    }
}