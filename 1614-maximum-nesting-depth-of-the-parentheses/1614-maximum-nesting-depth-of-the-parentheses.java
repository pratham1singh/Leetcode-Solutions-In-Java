class Solution {
    public int maxDepth(String s) {
        int n=s.length(),i=0;
        String str2="";
        Stack<Integer> st = new Stack<>();

        while(i<n){
            if(s.charAt(i)=='('||s.charAt(i)==')')
                str2+=s.charAt(i);
            i+=1;
        }
        i=0;
        while(i<str2.length()){
            if(str2.charAt(i)=='(')
                st.push(-i);
            else{
                int mx=0;
                while(st.peek()>0)
                    mx=Math.max(st.pop(),mx);
                st.pop();
                st.push(mx+1);
            }
            i+=1;
        }
        int ans=0;
        while(st.size()>0)
            ans=Math.max(ans,st.pop());
        return ans;
    }
}