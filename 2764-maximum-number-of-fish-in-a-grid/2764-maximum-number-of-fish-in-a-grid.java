class Solution {
    
    class node{
        int i,j;
        public node(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int ans=0,r,c;
    int isvisited[][];
    public void find(Queue<node>queue,int grid[][]){
        int l=1;
        while(l>0){
            node x=queue.remove();
            l-=1;
            ans+=grid[x.i][x.j];
            if(x.i+1<r&&grid[x.i+1][x.j]>0&&isvisited[x.i+1][x.j]==0){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                isvisited[x.i+1][x.j]=1;
            }
            if(x.i-1>=0&&grid[x.i-1][x.j]>0&&isvisited[x.i-1][x.j]==0){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                isvisited[x.i-1][x.j]=1;
            }
            if(x.j+1<c&&grid[x.i][x.j+1]>0&&isvisited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                isvisited[x.i][x.j+1]=1;
            }
            if(x.j-1>=0&&grid[x.i][x.j-1]>0&&isvisited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                isvisited[x.i][x.j-1]=1;
            }
        }
    }
    public int findMaxFish(int[][] grid) {
       
        int l=0,mx=0;
        r=grid.length;
        c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]>0){
                     Queue<node> queue=new LinkedList<>();
                     isvisited=new int[r][c];
                     isvisited[i][j]=1;
                     ans=0;
                     queue.add(new node(i,j));
                     l=1;
                     find(queue,grid);
                     if(mx<ans)
                        mx=ans;
                }
            }
        }
        return mx;
    }
}