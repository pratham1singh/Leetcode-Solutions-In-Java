class Solution {
    public int[][] generateMatrix(int n) {
        int r=n,c=n,i=0,j=0,k=1;
        int visited [][] = new int[r][c];
        int ans [][] = new int[r][c];
        char dir='r';
        
        
        while(k<=r*c){
            ans[i][j]=k;
            visited[i][j]=1;
            k+=1;
            
            if(dir=='r'){
                j+=1;
                if(j==c||visited[i][j]==1){
                    j-=1;
                    dir='d';
                    i+=1;
                }
                
            }
            else if(dir=='d'){
                i+=1;
                if(i==r||visited[i][j]==1){
                    dir='l';
                    j-=1;
                    i-=1;
                }
                
            }
            else if(dir=='l'){
                j-=1;
                if(j==-1||visited[i][j]==1){
                    dir='u';
                    i-=1;
                    j+=1;
                }
                
            }
            else if(dir=='u'){
                i-=1;
                if(i==-1||visited[i][j]==1){
                    dir='r';
                    j+=1;
                    i+=1;
                }
                
            }
            

        }
        return ans;
    }
}