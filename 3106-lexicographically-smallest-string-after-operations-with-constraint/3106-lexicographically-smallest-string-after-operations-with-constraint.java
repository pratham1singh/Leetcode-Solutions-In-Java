class Solution {
    int cost;
    public char findChar(char ch){
        char i='a';
        if(cost==0)
            return ch;
        while(i<ch){
            int b=(int)ch-97,a=(int)i-97;
            if(b-a<=cost&&(25-b+a+1)<=cost&&(b-a<25-b+a+1)){
                cost-=(int)(ch-i);
                return i;
            }
            if(b-a<=cost&&(25-b+a+1)<=cost&&(b-a>25-b+a+1)){
                cost-=(25-b+a+1);
                return i;
            }
            if(b-a<=cost){
                cost-=(int)(ch-i);
                return i;
            }
            if((25-b+a+1)<=cost){
                cost-=(25-b+a+1);
                return i;
            }
            i+=1;
        }
        return ch;
    }
    public String getSmallestString(String s, int k) {
        int n=s.length();
        cost=k;
        String ans="";
        for(int i=0;i<n;i++){
            ans+=findChar(s.charAt(i));
            // System.out.println(cost);
        }
            
        return ans;
    }
}