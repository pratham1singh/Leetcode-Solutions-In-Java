class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    int visited[],n,nums[];
    List<List<Integer>> ans = new ArrayList<>();

    public void find(int n,String str,List<Integer> arr){
        if(n==0&&map.get(str)==null){
            map.put(str,true);
            ans.add(new ArrayList<Integer>(arr));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    arr.add(nums[i]);
                    find(n-1,str+nums[i],arr);
                    visited[i]=0;
                    arr.remove(arr.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        n=nums.length;
        visited= new int[n];
        this.nums=nums;
        find(n,"",new ArrayList<Integer>());
        return ans;
    }
}