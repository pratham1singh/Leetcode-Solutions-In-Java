class Solution {
    public int maxOperations(String s) {
        int n=s.length(),i=0,c=0,ans=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i<n){
            if(s.charAt(i)=='0'){
                if(c!=0)
                    arr.add(c);
                c=0;
            }
            else
                c++;
            i++;
        }
        if(c!=0)
            arr.add(c);
        c=0;
        for(int x:arr){
            ans+=c;
            c+=x;
        }
        if(s.startsWith("1")&&s.endsWith("0")&&ans==0)
            return arr.get(0);
        return ans;
    }
}