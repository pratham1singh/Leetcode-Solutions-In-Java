class Solution {

    int fr,fc;
    String word;
    public boolean find(char[][] arr,int i,int l,int r,int c){
        if(i>=l)
            return true;
        else if (r>=fr||c>=fc||r<0||c<0)
            return false;
        else if(arr[r][c]!=word.charAt(i))
            return false;
        else{
           
            boolean ans=false;
            char a =arr[r][c];
            arr[r][c]='@';
            ans=find(arr,i+1,l,r+1,c)|| find(arr,i+1,l,r,c+1)||find(arr,i+1,l,r-1,c)|| find(arr,i+1,l,r,c-1);
            arr[r][c]=a;
            return ans;
        }
        
            
    }
    
    public boolean exist(char[][] board, String word) {
        fr=board.length;
            fc=board[0].length;
            this.word=word;
            for(int i=0;i<fr;i++){
                for(int j=0;j<fc;j++){
                    if(board[i][j]==word.charAt(0)){
                        if(find(board,0,word.length(),i,j))
                            return true;
                    }
                }
            }
            
            
            return false;
    }
}