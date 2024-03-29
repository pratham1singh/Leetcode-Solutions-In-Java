class node{
    int node,f;
    public node(int a,int b){
        node=a;
        f=b;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int arr []= new int[n];
        for(int x[]:roads){
            arr[x[0]]+=1;
            arr[x[1]]+=1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<node> pq = new PriorityQueue<>((p,q)->p.f-q.f);
        for(int i=0;i<n;i++)
            pq.add(new node(i,-arr[i]));
        int i=n;
        while(pq.size()>0){
            map.put(pq.poll().node,i);
            i-=1;
        }
        long ans=0;
        for(int x[]:roads){
            ans+=(map.get(x[0])+map.get(x[1]));
        }
        System.out.println(map);
        return ans;

    }
}