class node{
    int a,b;
    public node(int a ,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<node> st = new Stack<>();
        
         PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node p1, node p2) {
                if (p1.a != p2.a) {
                    return Integer.compare(p1.a, p2.a); 
                } else {
                    return Integer.compare(p1.b, p2.b); 
                }
            }
        });

        for(int x[]:intervals)
            pq.add(new node(x[0],x[1]));
        pq.add(new node(newInterval[0],newInterval[1]));
        st.add(pq.poll());
        while(pq.size()>0){
            node z=pq.poll();
            node y=st.peek();
            if(z.a>=y.a&&z.a<=y.b)
                y.b=Math.max(y.b,z.b);
            else
                st.push(z);
        }
        int ans[][] = new int[st.size()][2];
        for(int i=st.size()-1;i>=0;i--){
            ans[i][0]=st.get(i).a;
            ans[i][1]=st.get(i).b;
        }
        return ans;
    }
}