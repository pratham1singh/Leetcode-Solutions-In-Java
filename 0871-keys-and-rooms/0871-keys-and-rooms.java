class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer> queue=new LinkedList<>();
        int isvisited[]=new int[n];
        queue.add(0);
        isvisited[0]=1;
        int l=1;
        while(l>0){
            int x=queue.remove();
            l-=1;
            n-=1;
            for(Integer a:rooms.get(x)){
                if(isvisited[a]==0){
                    queue.add(a);
                    l+=1;
                    isvisited[a]=1;
                }
                
            }
        }
        return n==0;
    }
}