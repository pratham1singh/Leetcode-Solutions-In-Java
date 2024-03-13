class Solution {
    int n,nums[],solved[][][];

    public int find(int i,int k,int M){
        if(i==n)
            return 0;
        else if(solved[i][k][M]!=-1)
            return solved[i][k][M];
        else if(k==0){
            int ans=0,x=0;
            for(int j=0;j<2*M;j++){
                if(i+j>=n)
                    break;
                x+=nums[i+j];
                ans=Math.max(ans,x+find(i+j+1,1,Math.max(M,j+1)));
            }
            return solved[i][k][M]=ans;
        }
        else{
            int ans=1000000000;
            for(int j=0;j<2*M;j++){
                if(i+j>=n)
                    break;
                ans=Math.min(ans,find(i+j+1,0,Math.max(M,j+1)));
            }
            return solved[i][k][M] =ans;
        }
    }
    public int stoneGameII(int[] piles) {
        n=piles.length;
        nums=piles;

        solved= new int[100][2][100];
        for(int b[][]:solved)
            for(int c[]:b)
                Arrays.fill(c,-1);

        return find(0,0,1);
    }
}