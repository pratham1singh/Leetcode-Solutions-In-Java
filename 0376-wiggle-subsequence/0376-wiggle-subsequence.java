class Solution {
    int nums[],n,solved[][][];

    public int find(int i,int j,int diff){
        if(i==n)
            return 0;
        else if(j==-1)
            return Math.max(1+find(i+1,i,diff),find(i+1,j,diff));
        else if(solved[i][j][diff]!=-1)
            return solved[i][j][diff];
        else if(diff==0&&nums[i]-nums[j]>0)
            return solved[i][j][diff]=Math.max(1+find(i+1,i,1),find(i+1,j,diff));
        else if(diff==1&&nums[i]-nums[j]<0)
            return solved[i][j][diff]=Math.max(1+find(i+1,i,0),find(i+1,j,diff));
        else
            return solved[i][j][diff]=find(i+1,j,diff);
    }
    public int wiggleMaxLength(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        solved= new int[n][n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<2;k++)
                    solved[i][j][k]=-1;
        return Math.max(find(0,-1,0),find(0,-1,1));
    }
}