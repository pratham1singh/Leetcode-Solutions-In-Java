class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {

    int m,n,image[][],visited[][],color,initial;
    public void dfs(node x){

        if(visited[x.i][x.j]==0&&image[x.i][x.j]==initial){
            visited[x.i][x.j]=1;
            image[x.i][x.j]=color;
            if(x.i+1<m)
                dfs(new node(x.i+1,x.j));
            if(x.j+1<n)
                dfs(new node(x.i,x.j+1));
            if(x.i-1>=0)
                dfs(new node(x.i-1,x.j));
            if(x.j-1>=0)
                dfs(new node(x.i,x.j-1));
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m=image.length;
        this.n=image[0].length;
        this.visited= new int[m][n];
        this.image=image;
        this.color=color;
        this.initial=image[sr][sc];
        dfs(new node(sr,sc));
        return image;
    }
    
}