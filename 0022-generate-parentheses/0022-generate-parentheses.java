class Solution {
    int n;
    List<String> ans;
    public boolean is_valid(String str){
        Stack<Character> stack = new Stack<Character>();
        int i=0,l=0;
        while(i<2*n){
            if(str.charAt(i)=='('){
                stack.push('(');
                l+=1;
            }
            else if(l==0)
                return false;
            else{
                char top=stack.pop();
                l-=1;
                if(top==')'){
                    return false;
                }

            }
            i+=1;
        }
        for(String x:ans){
            if(x.equals(str))
                return false;
        }
        return l==0;
    }
    public void generate(String str,ArrayList<Character> arr,int l){
        if(l==2*n){
            if(is_valid(str))
            ans.add(str);
        }
        else{
            
            generate(str+arr.get(0),arr,l+1);
            generate(str+arr.get(1),arr,l+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        this.n=n;
        this.ans= new ArrayList<>();
        ArrayList<Character> arr= new ArrayList<>();
        String str="";
        arr.add(')');
        arr.add('(');
        generate(str,arr,0);
        return ans;
    }
}