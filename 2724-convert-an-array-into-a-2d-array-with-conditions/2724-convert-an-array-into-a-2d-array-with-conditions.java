class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.get(nums[i])==null)
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i])+1);
        }
        while(n>0){
            List<Integer> list1 = new ArrayList<>();
            for(int x:map.keySet()){
                if(map.get(x)>0){
                    list1.add(x);
                    map.put(x,map.get(x)-1);
                    n-=1;
                }
            }
            ans.add(list1);
        }
        return ans;


    }
}