class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int n=nums.length,i=0,j=1;

        while(j<n){
            if(nums[j]-nums[j-1]==1)
                j++;
            else{
                if(i==j-1)
                    ans.add(""+nums[i]);
                else
                    ans.add(nums[i]+"->"+nums[j-1]);
                i=j;
                j++;
            }
        }
        if(i==j-1)
            ans.add(""+nums[i]);
        else
            ans.add(nums[i]+"->"+nums[j-1]);
        return ans;
    }
}