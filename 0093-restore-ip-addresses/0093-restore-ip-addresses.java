class Solution {
    List<String> ans = new ArrayList<>();
    List<String> ans2 = new ArrayList<>();
    HashMap<Character,Integer> map = new HashMap<>();
    int n;
    String s;
    public void find(int i,String str,int c){
        if(i==n&&c==0)
            ans.add(str);
        else if(i==n||c==0)
            return;
        else if(s.charAt(i)=='0')
            find(i+1,str+".0",c-1);
        else {
            int num=0;
            for(int k=i;k<n;k++){
                num=num*10+map.get(s.charAt(k));
                if(num<=255){
                    find(k+1,str+'.'+num,c-1);
                }
                else
                    break;
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        this.s=s;
        map.put('0',0);map.put('1',1);map.put('2',2);map.put('3',3);map.put('4',4);map.put('5',5);map.put('6',6);map.put('7',7);map.put('8',8);map.put('9',9);
        find(0,"",4);
        for(String str:ans)
            ans2.add(str.substring(1));
        return ans2;
    }
}