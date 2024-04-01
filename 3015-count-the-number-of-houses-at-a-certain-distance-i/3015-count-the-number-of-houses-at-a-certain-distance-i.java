class node{
    int x,dis;
    public node(int x,int dis){
        this.x=x;
        this.dis=dis;
    }
}
class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int ans[][]= new int[n+1][n+1],arr[]= new int[n];
        for(int i=1;i<=n;i++){
            Queue<node> queue = new LinkedList<>();
            queue.add(new node(i,0));
            int visited[]= new int[n+1];
            visited[i]=1;
            while(queue.size()>0){
                node z=queue.remove();
                ans[i][z.x]=z.dis;
                ans[z.x][i]=z.dis;
                if(z.x<n&&visited[z.x+1]==0){
                    queue.add(new node(z.x+1,z.dis+1));
                    visited[z.x+1]=1;
                }
                if(z.x-1>=0&&visited[z.x-1]==0){
                    queue.add(new node(z.x-1,z.dis+1));
                    visited[z.x-1]=1;
                }
                if(z.x==x&&visited[y]==0){
                    queue.add(new node(y,z.dis+1));
                    visited[y]=1;
                }
                if(z.x==y&&visited[x]==0){
                    queue.add(new node(x,z.dis+1));
                    visited[x]=1;
                }
            }
        }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(ans[i][j]!=0)
                    arr[ans[i][j]-1]+=1;
        
        return arr;
    }
}