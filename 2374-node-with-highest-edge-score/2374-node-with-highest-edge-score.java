class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length,ind=0;
        long ans[]= new long[n],mx=0;
        for(int i=0;i<n;i++)
            ans[edges[i]]+=i;
        for(int i=0;i<n;i++){
            // System.out.println(ans[i]);
             if(ans[i]>mx){
                mx=ans[i];
                ind=i;
            }
        }
        return ind;
    }
}