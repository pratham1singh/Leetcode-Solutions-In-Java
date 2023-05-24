
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        ArrayList<Integer> max=new ArrayList<Integer>();
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null)
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        System.out.println(map);
        int i=k,inf=-1*(int)Math.pow(10,5);
        while(i>0){
            int mx=inf,val=inf;
            for(Integer x:map.keySet()){
                if(map.get(x)>val){
                    mx=x;
                    val=map.get(x);
                    }
                    
            }
            
            map.put(mx,inf);
            max.add(mx);
            i-=1;
        }
        
        i=0;
       for(Integer mx1:max){
            ans[i]=mx1;
            i+=1;
       }
        
        return ans;
    }
}