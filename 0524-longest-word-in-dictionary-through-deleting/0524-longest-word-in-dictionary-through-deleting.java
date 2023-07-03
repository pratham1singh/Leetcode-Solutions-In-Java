class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
       int l=s.length();
        
        String ans="";
        for(String str1:dictionary){
           
            int i=0,j=0,l2=str1.length();
            while(i<l&&j<l2){
                if(s.charAt(i)==str1.charAt(j)){
                    i+=1;
                    j+=1;
                }
                else
                    i+=1;

            }

            if(j==l2&&ans.length()<l2)
                ans=str1;
            else if(j==l2&&ans.length()==l2&&ans.compareTo(str1)>0)
                ans=str1;
        }
        return ans;
    }
}