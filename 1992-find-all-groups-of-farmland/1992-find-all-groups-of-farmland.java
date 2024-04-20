class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {

    int m,n,visited[][],r2,c2;

    public node bfs(node s,int land[][]){
        Queue<node> queue=new LinkedList<>();
        queue.add(s);
        int l=1;
        while(l>0){
            node x=queue.remove();
            r2=x.i;
            c2=x.j;
            l-=1;
            if(x.i+1<m&& visited[x.i+1][x.j]==0&& land[x.i+1][x.j]==1){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
            if(x.j+1<n && visited[x.i][x.j+1]==0&& land[x.i][x.j+1]==1){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
            if(x.i-1>=0&& visited[x.i-1][x.j]==0&& land[x.i-1][x.j]==1){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
            if(x.j-1>=0&& visited[x.i][x.j-1]==0&& land[x.i][x.j-1]==1){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            
        }
        return new node(r2,c2);

    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<int []> list1=new ArrayList<>();
        m=land.length;
        n=land[0].length;
        visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&land[i][j]==1){
                    visited[i][j]=1;
                    node x=bfs(new node(i,j),land);
                    int a[]=new int[4];
                    a[0]=i;
                    a[1]=j;
                    a[2]=x.i;
                    a[3]=x.j;
                    list1.add(a);
                }
            }
        }
        int ans[][]=new int [list1.size()][4],i=0;
        for(int x[]:list1){
            ans[i][0]=x[0];
            ans[i][1]=x[1];
            ans[i][2]=x[2];
            ans[i][3]=x[3];
            i+=1;
        }
        return ans;
    }
}