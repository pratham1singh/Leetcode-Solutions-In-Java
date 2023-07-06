class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int countBattleships(char[][] board) {
        int m=board.length,n=board[0].length,ans=0;
        int visited[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'&&visited[i][j]==0){

                    ans+=1;
                    Queue<node> queue = new LinkedList<>();
                    queue.add(new node(i,j));
                    visited[i][j]=1;
                    int l=1;
                    while(l>0){
                        node x=queue.remove();
                        l-=1;
                        
                        if(x.j+1<n&&board[x.i][x.j+1]=='X'&&visited[x.i][x.j+1]==0){
                            queue.add(new node(x.i,x.j+1));
                            l+=1;
                            visited[x.i][x.j+1]=1;
                        }
                        if(x.i+1<m&&board[x.i+1][x.j]=='X'&&visited[x.i+1][x.j]==0){
                            queue.add(new node(x.i+1,x.j));
                            l+=1;
                            visited[x.i+1][x.j]=1;
                        }
                    }
                }
            }
        }
        return ans;
    }
    
}