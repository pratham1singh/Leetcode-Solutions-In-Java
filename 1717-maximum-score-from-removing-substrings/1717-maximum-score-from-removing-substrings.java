class Solution {
    public int maximumGain(String s, int x, int y) {
        int n=s.length(),ans=0,i=0,c=y;
        String key="ba";
        Stack<Character> st = new Stack<>();
        if(x>y){
            key="ab";
            c=x;
        }
        while(i<n){
            if(st.size()==0){
                st.push(s.charAt(i));
            }
            else if(st.peek()==key.charAt(0)&&s.charAt(i)==key.charAt(1)){
                ans+=c;
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }

        s="";
        i=0;
        while(st.size()>0)
            s=st.pop()+s;

        n=s.length();
        if(c==x){
            c=y;
            key="ba";
        }
        else{
            c=x;
            key="ab";
        }

        while(i<n){
            if(st.size()==0){
                st.push(s.charAt(i));
            }
            else if(st.peek()==key.charAt(0)&&s.charAt(i)==key.charAt(1)){
                ans+=c;
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
        return ans;
    }
}