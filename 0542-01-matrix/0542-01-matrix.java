class node{
    int i,j,d;
    public node(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}

class Solution {

    int m,n,l=0;
    int visited[][],result[][];
    Queue<node> queue= new LinkedList<>();

    public void multi_bfs(Queue<node> queue){
        while(l>0){
            node x=queue.remove();
            result[x.i][x.j]=x.d;
            l-=1;
            if(x.i+1<m&&visited[x.i+1][x.j]==0){
                queue.add(new node(x.i+1,x.j,x.d+1));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
            if(x.j+1<n && visited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1,x.d+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
            if(x.j-1>=0 && visited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1,x.d+1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            if(x.i-1>=0 &&visited[x.i-1][x.j]==0){
                queue.add(new node(x.i-1,x.j,x.d+1));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        visited= new int[m][n];
        result= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new node(i,j,0));
                    l+=1;
                    visited[i][j]=1;

                }
            }
        }
        multi_bfs(queue);
        return result;
    }
}