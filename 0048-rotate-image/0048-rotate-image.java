class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
           int j=matrix.length-1,k=0;
           while(k<j){
               int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
              k+=1;
              j-=1;
           }
        }
    }
}