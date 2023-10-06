class Solution {
    int ans=1;
    HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
    // public void find(int n, int p){
    //     if(n==0)
    //         ans=Math.max(ans,p);
    //     else{
    //         for(int i=1;i<=n;i++){
    //             find(n-i,i*p);
    //         }
    //     }
    // }
    public int find(int n, int p){
       
        if(n==0)
            return p;
        else if(map.get(n)!=null&&map.get(n).get(p)!=null)
            return map.get(n).get(p);
        else{
            int x=1;
            for(int i=1;i<=n;i++){
                 x=Math.max(find(n-i,i*p),x);
                
            }
            if(map.get(n)!=null)
                map.get(n).put(p,x);
            else{
                HashMap<Integer,Integer> map2= new HashMap<>();
                map2.put(p,x);
                map.put(n,map2);
            }
            return x;
        }
    }
    public int integerBreak(int n) {
        if(n==3)
            return 2;
        if(n==2||n==1)
            return 1;
        return find(n,1);
       
    }
}