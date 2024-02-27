class Solution {
    List<List<Integer>> ans;
    int n,nums[];
    HashMap<String,Boolean> map;

    public void find(int i,List<Integer> arr,String s){
        
        int l=arr.size();
        
        if(i==n){
            // System.out.println(arr+" "+map+" "+s+" "+i+" "+arr.size());
            if(l>=2&&map.get(s)==null){
                ans.add(new ArrayList<Integer>(arr));
                map.put(s,true);
            }
        }
        else if(l>0&&nums[i]>=arr.get(l-1)){
            find(i+1,arr,s);
            arr.add(nums[i]);
            find(i+1,arr,s+"_"+nums[i]);
            arr.remove(l);
        }
        else if(l>0){
            find(i+1,arr,s);
        }
        else {
            find(i+1,arr,s);
            arr.add(nums[i]);
            find(i+1,arr,s+nums[i]);
            arr.remove(l);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans=new ArrayList<>();
        map = new HashMap<>();
        this.n=nums.length;
        this.nums=nums;
        find(0,new ArrayList<Integer>(),"");
        
        return ans;
    }
}