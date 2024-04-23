class Solution {
    int indeg[],visited[];
    HashMap<Integer,ArrayList<Integer>> child= new HashMap<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      
        for(int i=0;i<n;i++)
            child.put(i,new ArrayList<>());
        indeg= new int[n];
        int mx=Integer.MAX_VALUE;
        for(int x[]:edges){
             child.get(x[0]).add(x[1]);
             child.get(x[1]).add(x[0]);
             indeg[x[0]]+=1;
             indeg[x[1]]+=1;
        }
        List<Integer> ans = new ArrayList<>();
        int visited[]= new int[n],c=n;
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<n;i++)
            if(indeg[i]==1){
                queue.add(i);
                c-=1;
                visited[i]=1;
            }
        queue.add(null);
        while(c>0&&queue.size()>1){
            while(queue.peek()!=null){
                int z=queue.remove();
                indeg[z]-=1;
                for(int a:child.get(z)){
                     indeg[a]-=1;
                    if(visited[a]==0&&indeg[a]==1){
                        queue.add(a);
                        c-=1;
                        visited[a]=1;
                    }
                }
            
            }
            queue.remove();
            queue.add(null);
        }
        // System.out.println(queue);
        while(queue.size()>1){
            ans.add(queue.remove());
        }
        return ans;
    }
}