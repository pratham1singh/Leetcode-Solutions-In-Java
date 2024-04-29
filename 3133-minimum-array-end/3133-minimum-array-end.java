class Solution {
    public long minEnd(int n, int x) {
        int temp=x,c=0,arr[]=  new int[65],i=0;
        while(temp>0){
            if((temp&1)==0)
                c+=1;
            else
                arr[i]=1;
            i+=1;
            temp=temp>>1;
        }
        temp=n-1;
        i=0;
        while(i<65){
            if(arr[i]==0){
                arr[i]=temp&1;
                temp=temp>>1;
            }
            i+=1;
        }
        n=0;
        long ans=0;
        for(i=0;i<65;i++){
             ans+=arr[i]*(long)Math.pow(2,i);
            //  System.out.print(arr[i]);
        }
        return  ans;
    }
}