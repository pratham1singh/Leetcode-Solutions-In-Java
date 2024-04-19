class Solution {
    int n,arr[][];
    long solved[];
    public long find(int i){
        if(i==n)
            return 0;
        else if(solved[i]!=-1)
            return solved[i];
        else{
            long ans=find(i+1);
            int d=arr[i][1],k=i+1;
            for(k=i+1;k<n;k++)
                if(arr[k][0]>=d)
                    break;
             return solved[i]=Math.max(ans,arr[i][1]-arr[i][0]+arr[i][2]+find(k));
        }
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
        this.n=rides.length;
        arr=rides;
        solved= new long[this.n];
        Arrays.fill(solved,-1);
        return find(0);
    }
}