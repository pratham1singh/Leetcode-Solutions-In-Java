class Solution {
    int n;
    int[] arr,solved[];

    public int find(int i, int j) {
        if(j==n) return 0;
        if(i==-1){
            return Math.max(find(i,j+1), 1+ find(arr[j]%2,j+1));
        }
        if(solved[i][j]!=-1) return solved[i][j];
        if((i+arr[j])%2!=0){
             return solved[i][j]=Math.max(find(i,j+1), 1+ find(arr[j]%2,j+1));
        }
        return solved[i][j]=find(i,j+1);
    }
    public int maximumLength(int[] nums) {
        arr=nums;
        n=nums.length;
        solved = new int[2][n];
        for(int a[]: solved) Arrays.fill(a,-1);

        int x=0;
        for(int num:nums) if(num%2!=0) x++;

        return Math.max(Math.max(find(-1,0),x),n-x);
    }
}
