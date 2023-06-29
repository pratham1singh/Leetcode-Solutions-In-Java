class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Long> arr = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> list1 = new HashMap<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        for(int i=0;i<n;i++){
            list1.put(i,new ArrayList<Integer>());
        }
        for(int x[]:edges){
            list1.get(x[0]).add(x[1]);
            list1.get(x[1]).add(x[0]);

        }
        for(int i=0;i<n;i++){
            if(visited.get(i)==null){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int l=1;
                long c=0;
                visited.put(i,true);
        
                while(l>0){
                    int x=queue.remove();
                    l-=1;
                    c+=1;
                    for(int a:list1.get(x)){
                        if(visited.get(a)==null){
                            visited.put(a,true);
                            queue.add(a);
                            l+=1;
                        }
                    }
                }
                arr.add(c);
            }
        }
        if(arr.size()<=1){
            return 0;
        }
        long  ans=0,n1=n;
        for(long x:arr){
            ans+=(n1-x)*x;
            n1=n1-x;
        }
       
    return ans;
    }
}