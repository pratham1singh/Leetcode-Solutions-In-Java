class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n=s.length();
        for(int i=n-2;i>=0;i--)
            shifts[i]=(shifts[i]+shifts[i+1])%26;
        String ans="";
        // System.out.println(((int)'z'+1)%123);
        for(int i=0;i<n;i++){
            int ch=(int)s.charAt(i)-97;
            ans+=(char)((ch+shifts[i])%26+97);
        }
        return ans;
    }
}