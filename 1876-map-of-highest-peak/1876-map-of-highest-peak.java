class node{
    int i,j,d;
    public node(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length,n=isWater[0].length;
        Queue<node> queue =new LinkedList<>();
        int l=0;
        int visited[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1&&visited[i][j]==0){
                    queue.add(new node(i,j,0));
                    visited[i][j]=1;
                    l+=1;
                }
            }
        }
        while(l>0){
            node x=queue.remove();
            l-=1;
            isWater[x.i][x.j]=x.d;

            if(x.i+1<m&& visited[x.i+1][x.j]==0){
                queue.add(new node(x.i+1,x.j,x.d+1));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
             if(x.i-1>=0&& visited[x.i-1][x.j]==0){
                queue.add(new node(x.i-1,x.j,x.d+1));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
             if(x.j-1>=0&& visited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1,x.d+1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            if(x.j+1<n&& visited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1,x.d+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
        }
        return isWater;
    }
}