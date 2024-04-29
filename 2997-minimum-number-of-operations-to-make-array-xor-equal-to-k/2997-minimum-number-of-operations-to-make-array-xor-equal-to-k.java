class Solution {
    public int minOperations(int[] nums, int k) {
        int one[]= new int[33],zero[]= new int[33],ans=0,n=nums.length;
        for(int x:nums){
            int temp=x,i=0;

            while(temp>0){
                if((temp&1)==1)
                    one[i]+=1;
                temp=temp>>1;
                i+=1;
            }
        }
        for(int i=32;i>=0;i--){
            zero[i]=n-one[i];
        }
        int i=0;
        for(i=0;i<33;i++){
            // System.out.println((k&1)+" "+k);
            if((k&1)==1&&one[i]==0){
                ans+=1;
            }
            else if((k&1)==1&&one[i]%2==0&&zero[i]%2==0){
                ans+=1;
            }
            else if((k&1)==0&&one[i]!=0&&(one[i]%2!=0||zero[i]%2!=0))
                ans+=1;
            k=k>>1;
        }
        return ans;
    }
}