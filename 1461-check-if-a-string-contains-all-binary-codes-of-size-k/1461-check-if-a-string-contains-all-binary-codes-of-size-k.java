class Solution {
    ArrayList<String> arr = new ArrayList<>();
    int k;
    public void makeStrings(int i,String str){
        if(i==k)
            arr.add(str);
        else{
            makeStrings(i+1,str+"0");
            makeStrings(i+1,str+"1");
        }
    }
    public boolean hasAllCodes(String s, int k) {
        this.k=k;
        makeStrings(0,"");
        HashMap<String ,Boolean> map = new HashMap<>();
        for(int i=0;i<=s.length()-k;i++)
            map.put(s.substring(i,i+k),true);
        for(String str:arr)
            if(map.get(str)==null)
                return false;
        return true;
    }
}