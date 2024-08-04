class node{
    int x,dist;

    public node(int x,int dist){
        this.x=x;
        this.dist=dist;
    }
}
class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        int n=edges.length+1,cost[][]= new int[n][n],ans[]= new int[n];

        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<>());
        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            cost[x[0]][x[1]]=x[2];
            cost[x[1]][x[0]]=x[2];
        }

        for(int i=0;i<n;i++){
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
             int visited[]= new int[n];
                visited[i]=1;
            for(int a:adj.get(i)){
                ArrayList<Integer> list1 = new ArrayList<>();
                Queue<node> queue = new LinkedList<>();
                queue.add(new node(a,cost[i][a]));
               visited[a]=1;

                while(queue.size()>0){
                    node z=queue.remove();
                    if(z.dist%signalSpeed==0)
                        list1.add(z.x);
                    for(int b:adj.get(z.x))
                        if(visited[b]==0){
                            visited[b]=1;
                            queue.add(new node(b,z.dist+cost[z.x][b]));
                        }
                }
                arr.add(list1);
            }
            // System.out.println(arr);
            for(int j=0;j<arr.size();j++)
                for(int k=j+1;k<arr.size();k++){
                    ArrayList<Integer> l1=arr.get(j);
                    ArrayList<Integer> l2=arr.get(k);
                    for(int x:l1)
                        for(int y:l2)
                            if(x!=y)
                                ans[i]+=1;
                }

        }
        return ans;
    }
}