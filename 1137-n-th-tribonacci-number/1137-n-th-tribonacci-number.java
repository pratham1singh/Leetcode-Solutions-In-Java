class Solution {
     HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        else if(n==1||n==2)
            return 1;
        else{
            if(map.get(n)!=null)
                return map.get(n);
            else{
                map.put(n,tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3));
                return map.get(n);
            }
            
        }
    }
}