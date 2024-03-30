class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n=nums.length,i=0,j=0,c=1,ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);

        while(j<n){
            
            if(c<k){
                j+=1;
                if(j<n){
                    if(map.get(nums[j])!=null)
                        map.put(nums[j],map.get(nums[j])+1);
                
                    else{
                        map.put(nums[j],1);
                        c+=1;
                    }
                }
                
            }
            else if(c==k){
                int a=0,p=j+1;
                while(p<n&&map.get(nums[p])!=null){
                    p+=1;
                    a+=1;
                }
                ans+=(1+a);
                if(map.get(nums[i])==1){
                    map.remove(nums[i]);
                    c-=1;
                }
                else
                    map.put(nums[i],map.get(nums[i])-1);
                i+=1;

            }
        }
        
        return ans;
    }
}