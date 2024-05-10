class node{
    int a,b,f;
    public node(int a,int b,int f){
        this.a=a;
        this.b=b;
        this.f=f;
    }
}
class Solution {
    // public int find(int i,int j,int k){
    //     if(k==1)
    //         return arr[i]

    // }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<node> pq = new PriorityQueue<>((p,q)->{
            return p.f-q.f;
        });
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++)
                pq.add(new node(arr[i],arr[j],arr[i]/arr[j]));
        while(k>1){
            pq.poll();
            k-=1;
        }
        int ans[]=new int[2];
        ans[0]=pq.peek().a;
        ans[1]=pq.peek().b;
        return ans;
    }
}