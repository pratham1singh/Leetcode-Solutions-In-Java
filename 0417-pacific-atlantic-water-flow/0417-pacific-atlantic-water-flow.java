class node{
    int i,j;
    public  node(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {

    int m,n;
    List<List<Integer>> ans =new ArrayList<>();
    public void bfs(int i,int j,int arr[][]){
        int visited[][] =new int[m][n];
        Queue<node> queue =new LinkedList<>();
        queue.add(new node(i,j));
        int l=1;
        visited[i][j]=1;
        int p=-1,o=-1;
        while(l>0&&(p==-1||o==-1)){
        node x= queue.remove();
        //  System.out.println("a"+i+" "+j+" "+x.i+" "+x.j);
        l-=1;
        if(x.i==0||x.j==0){
            p=0;
        }
        if(x.i==m-1||x.j==n-1){
            o=0;
        }
        
        
        if(x.i+1<m&& arr[x.i+1][x.j]<=arr[x.i][x.j]&& visited[x.i+1][x.j]==0){
            queue.add(new node(x.i+1,x.j));
            l+=1;
            visited[x.i+1][x.j]=1;
        }
        if(x.i-1>=0&& arr[x.i-1][x.j]<=arr[x.i][x.j]&& visited[x.i-1][x.j]==0){
            queue.add(new node(x.i-1,x.j));
            l+=1;
            visited[x.i-1][x.j]=1;
        }
        if(x.j+1<n&& arr[x.i][x.j+1]<=arr[x.i][x.j]&& visited[x.i][x.j+1]==0){
            queue.add(new node(x.i,x.j+1));
            l+=1;
            visited[x.i][x.j+1]=1;
        }
        if(x.j-1>=0&& arr[x.i][x.j-1]<=arr[x.i][x.j]&& visited[x.i][x.j-1]==0){
            queue.add(new node(x.i,x.j-1));
            l+=1;
            visited[x.i][x.j-1]=1;
        }
        }
        if(p==0&&o==0){
            // System.out.println(i+" "+j);
            List<Integer> arr2=new ArrayList<>();
            arr2.add(i);
            arr2.add(j);
            ans.add(arr2);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                bfs(i,j,heights);
            }
        }
        return ans;
    }
}