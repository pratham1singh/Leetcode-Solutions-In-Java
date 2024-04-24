class Pair{
    int u,v;
    public Pair(int u,int v){
        this.u=u;
        this.v=v;
    }
}
class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> adj;
    HashMap<Integer,HashMap<Integer,Boolean>> flag;
    int visited[],dist[];
    public void Single_sourceSPath(int s){
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,q)->{
            return p.u-q.u;
        });
        pq.add(new Pair(0,s));
        while(pq.size()>0){
            Pair z=pq.poll();
            for(int a:adj.get(z.v).keySet())
                if(dist[a]>z.u+adj.get(z.v).get(a)){
                    dist[a]=z.u+adj.get(z.v).get(a);
                    pq.add(new Pair(dist[a],a));
                }
        }
    }
    public void dfs(int s ,int val,int d,ArrayList<Pair> arr){
        //   System.out.println(s+" "+val);

        if(s==d&&val==0){
            for(Pair x:arr)
                flag.get(x.u).put(x.v,true);
        }
        else if(val<0)
            return ;
        else{

            for(int a:adj.get(s).keySet())
                if(visited[a]==0){
                    visited[a]=1;
                    arr.add(new Pair(s,a));
                   dfs(a,val- adj.get(s).get(a),d,arr);
                   arr.remove(arr.size()-1);
                    visited[a]=0;
                }
        }
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        visited= new int[n];
        visited[0]=1;
        dist= new int[n];
        adj= new HashMap<Integer,HashMap<Integer,Integer>>();
        flag= new HashMap<Integer,HashMap<Integer,Boolean>>();
        boolean ans[]= new boolean[edges.length];
        for(int i=0;i<n;i++){
            adj.put(i,new HashMap<Integer,Integer>());
            flag.put(i,new HashMap<Integer,Boolean>());
        }
        for(int x[]:edges){
            adj.get(x[0]).put(x[1],x[2]);
            adj.get(x[1]).put(x[0],x[2]);
            flag.get(x[0]).put(x[1],false);
            flag.get(x[1]).put(x[0],false);
        }

        Single_sourceSPath(0);
        // System.out.println(dist[n-1]);
        dfs(0,dist[n-1],n-1,new ArrayList<Pair>());
        for(int i=0;i<edges.length;i++)
                if(flag.get(edges[i][0]).get(edges[i][1])||flag.get(edges[i][1]).get(edges[i][0]))
            // if(flag[edges[i][0]][edges[i][1]]==1||flag[edges[i][1]][edges[i][0]]==1)
                ans[i]=true;
        return ans;
    }
}