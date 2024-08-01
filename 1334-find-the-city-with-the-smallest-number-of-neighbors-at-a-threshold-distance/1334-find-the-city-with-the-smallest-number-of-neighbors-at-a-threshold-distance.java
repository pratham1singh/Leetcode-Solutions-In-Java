class node{
    int x,val;
    public node(int x,int val){
        this.x=x;
        this.val=val;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        int cost[][]= new int[n][n],dist[][]= new int[n][n];

        for(int i=0;i<n;i++)
            adj.put(i, new ArrayList<>());

        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            cost[x[0]][x[1]]=x[2];
            cost[x[1]][x[0]]=x[2];
        }

        for(int x[]:dist)
            Arrays.fill(x,Integer.MAX_VALUE);

        for(int s=0;s<n;s++){
            dist[s][s]=0;
            PriorityQueue<node> pq = new PriorityQueue<>((p,q)->p.val-q.val);
            pq.add(new node(s,0));

            while(pq.size()>0){
                node z=pq.poll();

                for(int a:adj.get(z.x))
                    if(dist[s][a]>z.val+cost[z.x][a]){
                        dist[s][a]=z.val+cost[z.x][a];
                        pq.add(new node(a,dist[s][a]));
                    }
            }

        }
        int ans=-1,count=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int c=0;
            for(int j=0;j<n;j++)
                if(dist[i][j]<=distanceThreshold)
                    c++;
            // System.out.println(c+" "+i);
            if(count>c){
                ans=i;
                count=c;
            }
        }
        return ans;
        

    }
}