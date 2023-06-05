class Solution {
    class node{
        int i,j;
        public node(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int n,count=0;
    public void check(Queue<node> queue,int grid[][]){
        int l=1;
        while(l>0){
            node x=queue.remove();
            l-=1;
            count+=1;
            if(x.i+2<n&&x.j+1<n&&grid[x.i+2][x.j+1]==count){
                queue.add(new node(x.i+2,x.j+1));
                l+=1;
            }
            else if(x.i+2<n&&x.j-1>=0&&grid[x.i+2][x.j-1]==count){
                queue.add(new node(x.i+2,x.j-1));
                l+=1;
            }
            else if(x.i-2>=0&&x.j+1<n&&grid[x.i-2][x.j+1]==count){
                queue.add(new node(x.i-2,x.j+1));
                l+=1;
            }
            else if(x.i-2>=0&&x.j-1>=0&&grid[x.i-2][x.j-1]==count){
                queue.add(new node(x.i-2,x.j-1));
                l+=1;
            }
            //
            else if(x.j+2<n&&x.i+1<n&&grid[x.i+1][x.j+2]==count){
                queue.add(new node(x.i+1,x.j+2));
                l+=1;
            }
            else if(x.j+2<n&&x.i-1>=0&&grid[x.i-1][x.j+2]==count){
                queue.add(new node(x.i-1,x.j+2));
                l+=1;
            }
            else if(x.j-2>=0&&x.i+1<n&&grid[x.i+1][x.j-2]==count){
                queue.add(new node(x.i+1,x.j-2));
                l+=1;
            }
            else if(x.j-2>=0&&x.i-1>=0&&grid[x.i-1][x.j-2]==count){
                queue.add(new node(x.i-1,x.j-2));
                l+=1;
            }
        }
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0)
            return false;
        Queue<node> queue=new LinkedList<>();
        queue.add(new node(0,0));
        n=grid.length;
        check(queue,grid);
        return count==n*n;
    }
}