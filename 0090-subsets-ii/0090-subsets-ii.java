class Solution {

   
    List<List<Integer>> list1 =new ArrayList<>();
    public boolean check(List<Integer>arr){
       
        for(List<Integer> a:list1 ){

            HashMap<Integer,Integer> map =new HashMap<>();
            for(Integer x:a){
                if(map.get(x)==null||map.get(x)<0)
                    map.put(x,1);
                else
                    map.put(x,map.get(x)+1);
            }
            int flag=0;
            for(Integer x:arr){
                if(map.get(x)==null){
                    flag=-1;
                    break;
                }
                else
                    map.put(x,map.get(x)-1);
            }
            if(flag==-1)
                continue;
            flag=0;
            for(Integer x:map.values())
                if(x!=0){
                    flag=-1;
                    break;
                }
            if(flag==-1)
                continue;
            return false;     
                
        }
        return true;
    }
    public void find(int nums[],int i,int n,List<Integer>arr){
        if(i==n){
            if(check(arr))
                list1.add(arr);
            return;
        }
        List<Integer> a1=new ArrayList<>(arr);
        List<Integer> a2=new ArrayList<>(arr);
        a2.add(nums[i]);
        find(nums,i+1,n,a1);
        find(nums,i+1,n,a2);


    }
   
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<Integer> a=new ArrayList<>();
        find(nums,0,nums.length,a);
        return list1;
    }
}