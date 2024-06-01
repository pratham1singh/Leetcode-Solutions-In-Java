class Solution {
    public int scoreOfString(String s) {
        int n=s.length(),ans=0,i=0;
        while(i<n-1){
            ans+=((int)(Math.abs(s.charAt(i)-s.charAt(i+1))));
            i+=1;
        }
        return ans;
        
    }
}