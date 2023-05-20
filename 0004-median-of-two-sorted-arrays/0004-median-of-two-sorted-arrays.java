class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,n1=nums1.length,n2=nums2.length,l1=n1,l2=n2;
        ArrayList<Integer> arr=new ArrayList<>();
        while(i<n1&&j<n2){
            if(nums1[i]==nums2[j]){
                arr.add(nums1[i]);
                arr.add(nums2[j]);
                i+=1;
                j+=1;
            }
            else if(nums1[i]<nums2[j]){
                arr.add(nums1[i]);
                i+=1;
            }
            else{
                arr.add(nums2[j]);
                j+=1;
            }
        }
        if(i==n1){
            i=j;
            n1=n2;
            nums1=nums2;
        }
        while(i<n1){
            arr.add(nums1[i]);
            i+=1;
        }
        if((l1+l2)%2==0){
            return (float)(arr.get((l1+l2)/2)+arr.get((l1+l2)/2-1))/(float)2;
        }
        return arr.get((int)((l1+l2)/2));
    }
}