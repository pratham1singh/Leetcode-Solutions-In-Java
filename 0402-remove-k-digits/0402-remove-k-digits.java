class Solution {
    public String removeKdigits(String s, int k) {
        int n=s.length(),i=0,ind=-1,c=k,t=0;
        String ans="";
        if(n<=k)
            return "0";
        i=0;
        while(i<n){
            if(s.charAt(i)!='0'&&c<=0)
                break;
            if(s.charAt(i)=='0'){
                ind=i;
            }
            else
                c-=1;
            
            i+=1;
        }
        // System.out.println(ind);
        i=0;
        while(i<=ind){
            if(s.charAt(i)!='0')
                k-=1;
            i+=1;
        }
        if(ind+1<n)
            s=s.substring(ind+1);
        else
            s="";
        n=s.length();
        if(n==0)
            return "0";
        System.out.println(k);
        i=0;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            if(st.size()>0&&s.charAt(st.peek())>s.charAt(i)&&k>0){
                st.pop();
                k-=1;
                // System.out.println(k+" "+z);
                
            }
            else{
                st.push(i);
                i+=1;
            }
        }
        while(st.size()>0)
            ans=s.charAt(st.pop())+ans;
        i=ans.length();
        // System.out.println(k);
        while(k>0&&i>=0){
            k-=1;
            i-=1;
        }
        if(i==-1)
            return "0";
        ans=ans.substring(0,i);
        if(ans.length()==0)
            return "0";
        return ans;
    }
}