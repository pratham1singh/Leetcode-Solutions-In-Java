class Solution {
     int isvisited[];
     int arr[][];
     public void bfs(int i,int n){
         Queue<Integer> queue=new LinkedList<>();
         queue.add(i);
         int l=1;
         while(l>0){
             int x=queue.remove();
             l-=1;
             isvisited[x]=1;
             for(int k=1;k<=n;k++){
                 if(arr[x-1][k-1]==1&&isvisited[k]==0){
                     queue.add(k);
                      isvisited[k]=1;
                      l+=1;
                 }
             }
         }
     }
    public int findCircleNum(int[][] isConnected) {
       int ans=0,n=isConnected.length;
       arr=isConnected;
       isvisited=new int [n+1];
        for(int i=1;i<=n;i++){
            if(isvisited[i]==0){
                ans+=1;
                isvisited[i]=1;
                bfs(i,n);
            }
        }
        return ans;
    }
}