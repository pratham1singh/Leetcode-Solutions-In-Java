class Solution {
    int visited[]= new int[10];
    List<List<Integer>> ans = new ArrayList<>();

    public void find(int i,int target,List<Integer> arr,int j){
        if(j==10&&i==0&&target==0){
            // System.out.println("A");
            ans.add(new ArrayList<>(arr));
        }
        else if(target<0||j==10)
            return;
        else{
            arr.add(j);
            find(i-1,target-j,arr,j+1);
            arr.remove(arr.size()-1);
            find(i,target,arr,j+1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        find(k,n,new ArrayList<>(),1);
        return ans;
    }
}