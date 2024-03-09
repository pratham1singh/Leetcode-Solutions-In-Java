class Solution {
    int n,m,nums1[],nums2[];

    public int find(int i,int j){
        if(i==n||j==m)
            return -1;
        else if(nums1[i]==nums2[j])
            return nums1[i];
        else if(nums1[i]<nums2[j])
            return find(i+1,j);
        else 
            return find(i,j+1);
    }
    public int getCommon(int[] nums1, int[] nums2) {
        n=nums1.length;
        m=nums2.length;
        this.nums1=nums1;
        this.nums2=nums2;
        return find(0,0);
    }
}