class Solution {

    List<List<Integer>> list1= new ArrayList<>();
    public void find(int arr[],List<Integer> ans,int n,int N){
        if(n==N){
            List<Integer> ans2 =new ArrayList<>(ans);
            list1.add(ans2);
            return;
        }
        else{
            for(int i=0;i<N;i++){
                if(arr[i]!=-11){
                    int x=arr[i];
                    arr[i]=-11;
                    ans.add(x);
                    n+=1;
                    find(arr,ans,n,N);
                    arr[i]=x;
                    ans.remove(n-1);
                    n-=1;
                }
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        find(nums,ans,0,nums.length);
        return list1;
    }
}