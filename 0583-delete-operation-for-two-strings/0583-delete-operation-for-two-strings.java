class Solution {
    String s1,s2;
    int n1,n2,solved[][];

    public int count(int i,int j){
        if(i==n1&&j==n2)
            return 0;
        else if(i==n1)
            return n2-j;
        else if(j==n2)
            return n1-i;
        else if(solved[i][j]!=-1)
            return solved[i][j];
        else if(s1.charAt(i)==s2.charAt(j)) return solved[i][j]=count(i+1,j+1);
        else return solved[i][j]=1+Math.min(count(i+1,j),count(i,j+1));
    }
    public int minDistance(String word1, String word2) {
        s1=word1;
        s2=word2;
        n1=s1.length();
        n2=s2.length();
        solved= new int[n1][n2];
        for(int x[]:solved) Arrays.fill(x,-1);
        return count(0,0);
    }

}