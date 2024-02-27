class Solution {
    public String entityParser(String text) {
        int n=text.length(),i=0;
        String ans="";

        while(i<n){
            if(text.charAt(i)=='&'){
                if(i+6<n&&text.substring(i,i+7).equals("&frasl;")){
                    ans+="/";
                    i+=7;
                }
                else if(i+5<n&&text.substring(i,i+6).equals("&quot;")){
                    ans+='"';
                    i+=6;
                }
                else if(i+5<n&&text.substring(i,i+6).equals("&apos;")){
                    ans+=(char)39;
                    i+=6;
                }
                else if(i+4<n&&text.substring(i,i+5).equals("&amp;")){
                    ans+="&";
                    i+=5;
                }
                else if(i+3<n&&text.substring(i,i+4).equals("&gt;")){
                    ans+=">";
                    i+=4;
                }
                else if(i+3<n&&text.substring(i,i+4).equals("&lt;")){
                    ans+="<";
                    i+=4;
                }
                else{
                    ans+=text.charAt(i);
                    i+=1;
                }
                    
            }
            else{
                ans+=text.charAt(i);
                i+=1;
            }
        }
        return ans;
    }
}