class Solution {
    int n,solved[][][],M=(int)(Math.pow(10,9)+7);
    public int find(int i,int late,int absent){
        if(i==n)
            return 1;
        else if(solved[i][late][absent]!=-1)
            return solved[i][late][absent];
        else if(absent<1&&late<2){
            int ans=0;
            ans=(ans+find(i+1,0,absent))%M; //P
            ans=(ans+find(i+1,0,absent+1))%M; //A
            ans=(ans+find(i+1,late+1,absent))%M; //L
            return solved[i][late][absent]=ans;

        }
        else if(absent<1&&late==2){
            int ans=0;
            ans=(ans+find(i+1,0,absent))%M; //P
            ans=(ans+find(i+1,0,absent+1))%M; //A
            return solved[i][late][absent]=ans;
        }
        else if(absent==1&&late<2){
            int ans=0;
            ans=(ans+find(i+1,0,absent))%M; //P
            ans=(ans+find(i+1,late+1,absent))%M; //L
            return solved[i][late][absent]=ans;
        }
        else{
            int ans=0;
            ans=(ans+find(i+1,0,absent))%M; //P
            return solved[i][late][absent]=ans;
        }
        
    }
    public int checkRecord(int n) {
        this.n=n;
        solved= new int[n][3][2];
        for(int x[][]:solved)
            for(int y[]:x)
                Arrays.fill(y,-1);
        return find(0,0,0)%M;
    }
}