class node{
    char ch;
    int freq;
    public node(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<node> pq = new PriorityQueue<node>((x,y)->x.freq-y.freq);
        pq.add(new node('a',-a));
        pq.add(new node('b',-b));
        pq.add(new node('c',-c));
        String ans="";
        while(pq.size()>0){
            if(ans.endsWith(""+pq.peek().ch)==false){
                node x=pq.poll();
                if(x.freq==0)
                    continue;
                if(-1*x.freq>1){
                    ans+=""+x.ch+x.ch;
                    x.freq+=2;
                }
                else{
                    ans+=""+x.ch;
                    x.freq+=1;
                }
                pq.add(x);
            }
           else if(pq.size()>1){
                node y=pq.poll();
                node x=pq.poll();
                if(x.freq==0)
                    continue;
                ans+=""+x.ch;
                x.freq+=1;
                pq.add(x);
                pq.add(y);
           }
           else
            break;
        }
        return ans;
    }
}