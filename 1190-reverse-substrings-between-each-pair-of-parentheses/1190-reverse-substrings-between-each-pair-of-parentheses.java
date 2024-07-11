class Solution {
    public String reverseParentheses(String s) {
        int n=s.length(),i=0;
        String ans="";
        Stack<Character> st = new Stack<>();

        while(i<n){
            if(s.charAt(i)!=')')
                st.push(s.charAt(i));
            else {
                String str="";
                while(st.size()>=0&&st.peek()!='(')
                    str+=st.pop();
                st.pop();
                for(int k=0;k<str.length();k++)
                    st.push(str.charAt(k));
                
            }
            i++;
        }
        while(st.size()>0)
            ans=st.pop()+ans;
        return ans;
    }
}