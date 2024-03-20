class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length,visited[][]= new int[n][n],label[]= new int[n];
        Arrays.fill(label,-1);
        Queue<Integer> queue = new LinkedList<>();
       

       for(int k=0;k<n;k++){
        if(label[k]==-1){
            label[k]=0;
             queue.add(k);
            while(queue.size()>0){
            int i=queue.remove();
            int x=1-label[i];
            for(int a:graph[i]){
                if(visited[i][a]==0){
                    queue.add(a);
                    visited[i][a]=1;
                    if(label[a]==label[i])
                        return false;
                    else
                        label[a]=x;
                }

            }
        }
        }
       }
        return true;

    }
}