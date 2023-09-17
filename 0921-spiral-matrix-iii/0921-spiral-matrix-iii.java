class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int r=rows,c=cols,i=rStart,j=cStart,k=1;
        
            
        int visited [][] = new int[r][c];
        char dir[]={'r','d','l','u'};
        int ans[][] = new int[r*c][2],x=0,d=0;
        
        while(k<=r*c){
            if(i>=0&&j>=0&&i<r&&j<c&&visited[i][j]==0){
              ans[x][0]=i;
              ans[x][1]=j;
              k+=1;
              x+=1;
              visited[i][j]=1;
              
            }
            
            
            
            if(dir[d]=='r'){
                j+=1;
                if(i>=0&&j>=0&&i<r&&j<c&&visited[i][j]==1){
                    j-=1;
                    d=(d-1);
                    if(d<=-1)
                        d=3;
                }
                else{
                    d =(d+1)%4;
                }
                
            }
            else if(dir[d]=='d'){
                i+=1;
                if(i>=0&&j>=0&&i<r&&j<c&&visited[i][j]==1){
                    i-=1;
                    d=(d-1);
                    if(d<=-1)
                        d=3;
                }
                else{
                    d =(d+1)%4;
                }
                
            }
            else if(dir[d]=='l'){
                j-=1;
                if(i>=0&&j>=0&&i<r&&j<c&&visited[i][j]==1){
                    j+=1;
                    d=(d-1);
                    if(d<=-1)
                        d=3;
                }
                else{
                    d =(d+1)%4;
                }
                
            }
            else if(dir[d]=='u'){
                i-=1;
                if(i>=0&&j>=0&&i<r&&j<c&&visited[i][j]==1){
                    i+=1;
                    d=(d-1);
                    if(d<=-1)
                        d=3;
                }
                else{
                    d =(d+1)%4;
                }
                
            }
            

        }
        return ans;
    }
}