class Solution {
     public int find2(int i,int[] arr,int n,int solved[]){
        if(i==n)
            return 0;
        else if(solved[i]!=-1)
            return solved[i];
        int ans=0;
        for(int k=i+1;k<n;k++)
            if(arr[k]>arr[i])
                ans=Math.max(ans,1+find2(k,arr,n,solved));
        return solved[i]=ans;
    }
    public int lengthOfLIS(int[] arr) {
         int ans=0,n=arr.length;
        int solved[]= new int[n];
        // for(int x[]:solved)
            Arrays.fill(solved,-1);
       for(int i=0;i<n;i++)
            ans=Math.max(ans,1+find2(i,arr,n,solved));
        return ans;
    }
}