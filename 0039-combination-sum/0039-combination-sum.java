class Solution {

    List<List<Integer>> ans=new ArrayList<>();
    public void find(int arr[],int s,List<Integer> path,int i ,int l){
        if(s==0){
            ans.add(path);
            return;
        }
        else if(i>=l)
            return;
        else if(arr[i]<=s){
            find(arr,s,path,i+1,l);
            List <Integer> path2=new ArrayList<>(path);
            path2.add(arr[i]);
            find(arr,s-arr[i],path2,i,l);
        }
        else{
            find(arr,s,path,i+1,l);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> a=new ArrayList<>();
        find(candidates,target,a,0,candidates.length);
        return ans;
    }
}