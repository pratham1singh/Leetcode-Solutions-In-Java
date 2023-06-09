class Solution {
    List<List<Integer>> list1 =new ArrayList<>();
    public void find(int nums[],int i,int n,List<Integer>arr){
        if(i==n){
            list1.add(arr);
            return;
        }
        List<Integer> a1=new ArrayList<>(arr);
        List<Integer> a2=new ArrayList<>(arr);
        a2.add(nums[i]);
        find(nums,i+1,n,a1);
        find(nums,i+1,n,a2);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> a=new ArrayList<>();
        find(nums,0,nums.length,a);
        return list1;
    }
}