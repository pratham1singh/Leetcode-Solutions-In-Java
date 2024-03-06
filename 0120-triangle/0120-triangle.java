class Solution {
    List<List<Integer>> triangle;
    int n,solved[][];
    public int find(int i,int j){
        if(i==n)
            return 0;
        else if(solved[i][j]!=-1)
            return solved[i][j];
        else{
            return solved[i][j]=Math.min(triangle.get(i).get(j)+find(i+1,j),triangle.get(i).get(j)+find(i+1,j+1));
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        this.triangle=triangle;
        solved= new int[n][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        return find(0,0);
    }
}