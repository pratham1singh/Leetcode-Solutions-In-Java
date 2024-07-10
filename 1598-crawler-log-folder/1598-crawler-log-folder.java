class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<logs.length;i++){
            if(logs[i].startsWith("../")&&st.size()>0)
                st.pop();
            else if(logs[i].startsWith("./"))
                continue;
            else
                st.push(logs[i]);

        }
        return st.size();
    }
}