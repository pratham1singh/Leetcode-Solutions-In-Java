class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {

    public boolean hasValidPath(int[][] grid) {
        
        int m=grid.length,n=grid[0].length;
        int visited[][]=new int[m][n];
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(0,0));
        int l=1;
        while(l>0){
            node x=queue.remove();
            l-=1;
            System.out.println(x.i+" "+x.j);
            if(x.i==m-1&&x.j==n-1)
                return true;

            if(grid[x.i][x.j]==1){
                if(x.j+1<n&&visited[x.i][x.j+1]==0&&(grid[x.i][x.j+1]==3||grid[x.i][x.j+1]==5||grid[x.i][x.j+1]==1)){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
                }
                if(x.j-1>=0&&visited[x.i][x.j-1]==0&&(grid[x.i][x.j-1]==4||grid[x.i][x.j-1]==6||grid[x.i][x.j-1]==1)){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
                }
                
            }
            if(grid[x.i][x.j]==2){

               if(x.i+1<m&&visited[x.i+1][x.j]==0&&(grid[x.i+1][x.j]==6||grid[x.i+1][x.j]==5||grid[x.i+1][x.j]==2)){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
                }
                if(x.i-1>=0&&visited[x.i-1][x.j]==0&&(grid[x.i-1][x.j]==3||grid[x.i-1][x.j]==4||grid[x.i-1][x.j]==2)){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
                }
            }
            if(grid[x.i][x.j]==3){
                if(x.i+1<m&&visited[x.i+1][x.j]==0&&(grid[x.i+1][x.j]==2||grid[x.i+1][x.j]==5||grid[x.i+1][x.j]==6)){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
                }
                if(x.j-1>=0&&visited[x.i][x.j-1]==0&&(grid[x.i][x.j-1]==1||grid[x.i][x.j-1]==4||grid[x.i][x.j-1]==6)){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
                }
            }
            if(grid[x.i][x.j]==4){
               if(x.j+1<n&&visited[x.i][x.j+1]==0&&(grid[x.i][x.j+1]==1||grid[x.i][x.j+1]==5||grid[x.i][x.j+1]==3)){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
                }
                if(x.i+1<m&&visited[x.i+1][x.j]==0&&(grid[x.i+1][x.j]==2||grid[x.i+1][x.j]==5||grid[x.i+1][x.j]==6)){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
                }
            }
             if(grid[x.i][x.j]==5){
               if(x.i-1>=0&&visited[x.i-1][x.j]==0&&(grid[x.i-1][x.j]==2||grid[x.i-1][x.j]==4||grid[x.i-1][x.j]==3)){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
                }
                if(x.j-1>=0&&visited[x.i][x.j-1]==0&&(grid[x.i][x.j-1]==1||grid[x.i][x.j-1]==4||grid[x.i][x.j-1]==6)){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
                }
            }
             if(grid[x.i][x.j]==6){
                if(x.j+1<n&&visited[x.i][x.j+1]==0&&(grid[x.i][x.j+1]==1||grid[x.i][x.j+1]==5||grid[x.i][x.j+1]==3)){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
                }
                if(x.i-1>=0&&visited[x.i-1][x.j]==0&&(grid[x.i-1][x.j]==4||grid[x.i-1][x.j]==3||grid[x.i-1][x.j]==2)){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
                }
            }
            
        }
        return false;
    }
}