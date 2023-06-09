class Solution {
    List<String> list1=new ArrayList<>();
    HashMap<Character,Boolean> map=new HashMap<>();
    public void find(String str ,String ans,int i,int n){
        if(i==n){
            if(list1.contains(ans)==false)
            list1.add(ans);
            return;
        }
        if(map.get(str.charAt(i))==null){
            find(str,ans+ Character.toUpperCase(str.charAt(i)),i+1,n);
            find(str,ans+ Character.toLowerCase(str.charAt(i)),i+1,n);
        }
        else
            find(str,ans+ str.charAt(i),i+1,n);
    }
    public List<String> letterCasePermutation(String s) {
        map.put('1',true);map.put('2',true);map.put('3',true);map.put('4',true);map.put('5',true);map.put('6',true);map.put('7',true);map.put('8',true);map.put('9',true);

        String str="";
        find(s,str,0,s.length());
        return list1;
    }
}