class Solution {
    int n,visited[];
    public boolean find(int i,int nums[]){
        if(i==n-1)
            return true;
        else if(i>=n)
            return false;
        else if(visited[i]!=-1)
            return visited[i]==1?true:false;
        else{
            boolean ans=false;
            for(int j=1;j<=nums[i];j++){
                ans=ans||find(i+j,nums);
            }
            if(ans)
                visited[i]=1;
            else
                visited[i]=0;
            return ans;
        }
    }
    public boolean canJump(int[] nums) {
        n=nums.length;
        visited= new int[n];
        for(int i=0;i<n;i++)
            visited[i]=-1;
        return find(0,nums);
    }
}