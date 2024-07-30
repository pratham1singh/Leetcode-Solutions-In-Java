class Solution {
    public int minimumDeletions(String s) {
        int n=s.length(),b_count=0,i=0,a_count=0,ans=Integer.MAX_VALUE;

        while(i<n)
            if(s.charAt(i++)=='b')
                b_count++;
        i=0;
        ans=n-b_count;
        while(i<n){
            if(s.charAt(i)=='a') a_count++;
            if(s.charAt(i)=='b') b_count--;
            ans=Math.min(ans,i+1-a_count+(n-i-1-b_count));
            
            i++;
        }
        
        return ans;
    }
}