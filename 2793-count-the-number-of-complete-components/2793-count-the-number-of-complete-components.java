class Solution {
    HashMap<Integer,ArrayList<Integer>> list=new HashMap<>();
    int isvisited[];

    public int bfs(int i){
            Queue<Integer> queue=new LinkedList<>();
            queue.add(i);
            int l=1,n=0;
            while(l>0){
                int x=queue.remove();
                l-=1;
                n+=1;
                for(Integer k:list.get(x)){
                    if(isvisited[k]==0){
                        isvisited[k]=1;
                        queue.add(k);
                        l+=1;
                    }
                }
            }
            return n;
    }
    public boolean is_bfs(int i,int n,int k){
        int arr[]=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        int l=1;
        while(l>0){
            int x=queue.remove();
            l-=1;
            arr[x]=1;
            if(list.get(x).size()!=k)
                return false;
            for(Integer a:list.get(x)){
                if(arr[a]==0){
                    arr[a]=1;
                    queue.add(a);
                    l+=1;
                }
            }
        }
        return true;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            list.put(i,new ArrayList<Integer>());
        }
        for(int x []:edges){
            list.get(x[0]).add(x[1]);
             list.get(x[1]).add(x[0]);
        }
        isvisited=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(isvisited[i]==0){
                isvisited[i]=1;
                int k=bfs(i);
                
                if(is_bfs(i,n,k-1))
                    ans+=1;
            }
        }
        
        return ans;
    }
}