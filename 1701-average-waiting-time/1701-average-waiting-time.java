class Solution {
    public double averageWaitingTime(int[][] arr) {
        int t=arr[0][0],n=arr.length;
        double ans=0;
        
        for(int i=0;i<n;i++){
            if(t>=arr[i][0]){
                 t+=arr[i][1];
                ans+=(t-arr[i][0]);
            }
            else{
                 t=arr[i][0]+arr[i][1];
                ans+=arr[i][1];
            }
            
        }
        System.out.println(ans);
        return ans/(double)n;

    }
}