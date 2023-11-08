class Solution {
    int n;
    public boolean find(int i,int arr[],int visited[]){
        if(i>=n||i<0)
            return false;
        else if(arr[i]==0)
            return true;
        else if(visited[i]==1)
            return false;
        else{
            boolean ans=false;
            visited[i]=1;
            ans=ans || find(i+arr[i],arr,visited);
            ans=ans || find(i-arr[i],arr,visited);
            visited[i]=0;
            return ans;
        }
    }
    public boolean canReach(int[] arr, int start) {
        n=arr.length;
        int visited[]= new int[n];
        return find(start,arr,visited);
    }
}