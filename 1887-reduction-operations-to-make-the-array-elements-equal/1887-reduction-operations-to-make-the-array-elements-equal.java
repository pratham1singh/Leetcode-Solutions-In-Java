class node{
    int x,f;
    public node(int x,int f){
        this.x=x;
        this.f=f;
    }
}
class Solution {
    public int reductionOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:nums)
            if(map.get(x)!=null)
                map.put(x,map.get(x)+1);
            else
                map.put(x,1);
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) ->a.x-b.x);
        for(int a:map.keySet())
            pq.add(new node(-a,map.get(a)));
        int ans=0;
        while(pq.size()>1){
            node a=pq.poll(),b=pq.poll();
            ans+=a.f;
            b.f+=a.f;
            pq.add(b);
        }
        return ans;
    }
}