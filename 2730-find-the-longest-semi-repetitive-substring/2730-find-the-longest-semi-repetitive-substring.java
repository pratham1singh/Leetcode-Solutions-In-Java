class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n=s.length(),c=0,ans=0,i=0,j=0;
        Queue<Integer> queue = new LinkedList<>();
        while(j<n){
            System.out.println(i+" "+j+" "+c);
            ans=Math.max(ans,j-i+1);
            j+=1;
            if(j<n){
                if(s.charAt(j-1)==s.charAt(j)){
                    if(c==0){
                        queue.add(j-1);
                        c=1;
                    }
                    else{
                        i=queue.remove()+1;
                        queue.add(j-1);
                        c=1;
                    }
                }
            }
        }
        return ans;
    }
}