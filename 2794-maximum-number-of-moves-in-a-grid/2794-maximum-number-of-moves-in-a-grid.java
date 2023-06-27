class node{
    int i,j,d;
    public node(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    int r,c,ans;
    public int find(int arr[][],int i,int j){
        int l=1;
        Queue<node> queue = new LinkedList<>();
        int visited[][]= new int[r][c];
        queue.add(new node(i,j,0));
        visited[i][j]=1;

        while(l>0){
            node x= queue.remove();
            l-=1;

            if(x.i-1>=0&&x.j+1<c&&visited[x.i-1][x.j+1]==0&&arr[x.i-1][x.j+1]>arr[x.i][x.j]){
                queue.add(new node(x.i-1,x.j+1,x.d+1));
                l+=1;
                visited[x.i-1][x.j+1]=1;
            }
            if(x.j+1<c&&visited[x.i][x.j+1]==0&&arr[x.i][x.j+1]>arr[x.i][x.j]){
                queue.add(new node(x.i,x.j+1,x.d+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
             if(x.i+1<r&&x.j+1<c&&visited[x.i+1][x.j+1]==0&&arr[x.i+1][x.j+1]>arr[x.i][x.j]){
                queue.add(new node(x.i+1,x.j+1,x.d+1));
                l+=1;
                visited[x.i+1][x.j+1]=1;
            }
            if(l==0)
                return x.d;
        }
        return 0;
    }
    public int maxMoves(int[][] grid) {
        r=grid.length;
        c=grid[0].length;
        for(int i=0;i<r;i++){
            
            ans=Math.max(ans,find(grid,i,0));
            
        }
        return ans;
    }
}