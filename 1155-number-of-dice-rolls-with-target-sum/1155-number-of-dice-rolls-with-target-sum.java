class Solution {
    int n,k,target,M=(int)Math.pow(10,9)+7;
    long solved[][];
    public long find(int i,int val){
        if(val==target&&i==n+1)
            return 1;
        else if(i>n||val>target)
            return 0;
        else if(solved[i][val]!=-1)
            return solved[i][val];
        else{
            long ans=0;
            for(int j=1;j<=k;j++)
                ans+=find(i+1,val+j);
            return solved[i][val]=(int)(ans%M);
        }
    }
    public int numRollsToTarget(int n, int k, int target) {
        this.n=n;
        this.k=k;
        this.target=target;
        solved= new long[n+1][target+1];
        for(long x[]:solved)
            Arrays.fill(x,-1);
        return (int)(find(1,0)%M);
    }
}