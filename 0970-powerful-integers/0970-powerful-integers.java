class Solution {
    int x,y;
    HashMap<Integer,Boolean> map ;
    public boolean isPowy(int num){
        
        if(map.get(num)!=null)
            return map.get(num);
        else
            return false;
        
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        this.x=x;
        this.y=y;
        map=new HashMap<>();
        int c=0;
        if(y!=1)
            while(Math.pow(y,c)<=bound){
                map.put((int)Math.pow(y,c),true);
                c+=1;
            }
        map.put(1,true);
        
        List<Integer> ans = new ArrayList<>();
        int i;
        
        if(x==1){
            
            for(i=1;i<=bound;i++)
                if(isPowy(i-1))
                    ans.add(i);
            return ans;
        }
        for(i=1;i<=bound;i++){
            int k=0;
            while(Math.pow(x,k)<=i){
                if(isPowy(i-(int)Math.pow(x,k))){
                    ans.add(i);
                    break;
                }
                k+=1;
            }   
        }
        
        
        return ans;
    }
}