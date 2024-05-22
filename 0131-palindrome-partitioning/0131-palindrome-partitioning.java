class Solution {
    public boolean isPalin(String s){
        int n=s.length(),i=0,j=n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i+=1;
            j-=1;
        }
        return true;
    }
    List<List<String>> ans = new ArrayList<>();
    public void find(String s,List<String> arr){
        int n=s.length();
        if(n==0){
            ans.add(new ArrayList<>(arr));
        }
        else {
            for(int i=0;i<n;i++){
                if(isPalin(s.substring(0,i+1))){
                    arr.add(s.substring(0,i+1));
                    find(s.substring(i+1),arr);
                    arr.remove(arr.size()-1);
                }
            }
        }
    }
    public List<List<String>> partition(String s) {
        find(s,new ArrayList<String>());
        return ans;
    }
}