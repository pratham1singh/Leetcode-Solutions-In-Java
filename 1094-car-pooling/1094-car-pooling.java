class Trip{
    int p,f,t;
    public Trip(int p,int f ,int t){
        this.p=p;
        this.f=f;
        this.t=t;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Trip> pq = new PriorityQueue<>((p,q)->{
            return p.t-q.t;
        });
        Arrays.sort(trips,Comparator.comparingInt(a -> a[1]));
        int c=capacity,i=0,k=0,n=trips.length;

        while(k<n){

            int []x=trips[k];
            while(pq.size()>0&&i==pq.peek().t){
                c+=pq.peek().p;
                pq.poll();
            }
            while(k<n&&i==trips[k][1]){
                x=trips[k];
                if(c<x[0])
                    return false;
                c-=x[0];
                pq.add(new Trip(x[0],x[1],x[2]));
                k+=1;
            }
            if(pq.size()==0&&k<n)
                i=trips[k][1];
            else if(k<n)
                i=Math.min(trips[k][1],pq.peek().t);
        }
        return true;
    }
}