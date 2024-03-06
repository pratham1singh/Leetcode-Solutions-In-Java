class Solution {
    int n,solved[][];
    public int find(int i,int j){
        if(i==n)
            return 1;
        else if(j==5)
            return 0;
        else if(solved[i][j]!=-1)
            return solved[i][j];
        else
            return solved[i][j]=find(i+1,j)+find(i,j+1);
        
    }
    public int countVowelStrings(int n) {
        this.n=n;
        solved= new int[n][5];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        return find(0,0);
    }
}