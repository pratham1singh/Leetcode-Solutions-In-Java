class Solution {

    HashMap<Integer,ArrayList<Integer>> list =new HashMap<>();
    HashMap<Integer,List<Integer>> bfs_list =new HashMap<>();

    public void bfs(int i, List<Integer>arr){
        Queue<Integer> queue =new LinkedList<>();
         HashMap<Integer,Boolean> visited =new HashMap<>();
        queue.add(i);
        int l=1;
        visited.put(i,true);
        while(l>0){
            int x=queue.remove();
            arr.add(x);
            l-=1;
            for(int a:list.get(x)){
                if(visited.get(a)==null){
                    queue.add(a);
                    l+=1;
                    visited.put(a,true);
                }
            }
        }

    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            list.put(i,arr);
        }
        for(int x[]:edges){
            list.get(x[0]).add(x[1]);
           
        }
        for(int i=0;i<n;i++){
            List<Integer> arr =new ArrayList<>();
            bfs(i,arr);
            bfs_list.put(i,arr);
        }

        for(int i=0;i<n;i++){
            List<Integer> arr =new ArrayList<>();
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(bfs_list.get(j).contains(i)){
                        arr.add(j);
                    }
                }
            }
            ans.add(arr);
        }
        return ans;

    }
}