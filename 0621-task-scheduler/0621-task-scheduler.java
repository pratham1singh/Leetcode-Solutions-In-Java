class node{
    char ch;
    int f,w;
    public node(char ch,int f,int w){
        this.f=f;
        this.ch=ch;
        this.w=w;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:tasks)
            if(map.get(ch)!=null)
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        PriorityQueue<node> pq = new PriorityQueue<>((p,q)->p.w-q.w);
        for(char ch:map.keySet()){
            pq.add(new node(ch,map.get(ch),0));
        }
        int ans=0,t=0;
        while(pq.size()>0){
           if(pq.peek().w<=t){
                node z=pq.poll();
                z.f-=1;
                z.w+=n+1;
                if(z.f>0)
                    pq.add(z);
           }
           ans+=1;
           t+=1;
        }
        return ans;

    }
}