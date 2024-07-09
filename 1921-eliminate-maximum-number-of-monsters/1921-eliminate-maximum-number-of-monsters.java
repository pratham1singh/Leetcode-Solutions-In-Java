class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length,time[]= new int[n],t,i,ans=1;

        for(i=0;i<n;i++)
            time[i]=dist[i]/speed[i];
        Arrays.sort(time);

        t=1;
        i=1;

        while(i<n){
            if(time[i]>t){
                t++;
                i++;
                ans++;
            }
            else
                break;
        }
        return ans;
    }
}