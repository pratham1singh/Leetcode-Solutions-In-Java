class Solution {
    public int compress(char[] chars) {
        int  n=chars.length,i=0,count=1;
        String str="";
        while(i<n-1){
            
            if(chars[i]!=chars[i+1]){
                if(count>1)
                    str+=(""+chars[i])+count;
                else
                    str+=chars[i];
                count=1;
            }
            else
                count+=1;
            i+=1;
        }
       
            if(n>1&&chars[n-2]!=chars[n-1])
                str+=chars[n-1];
            else if(n>1)
                str+=(""+chars[i])+count;
            else
                str+=chars[i];
        for(i=0;i<str.length();i++){
            chars[i]=str.charAt(i);
        }
        return str.length();
    }
}