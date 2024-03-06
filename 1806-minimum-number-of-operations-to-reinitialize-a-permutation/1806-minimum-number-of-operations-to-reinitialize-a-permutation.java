class Solution {
    public int reinitializePermutation(int n) {
        int ans=0,perm[]= new int[n],arr[]=new int[n];
        for(int i=0;i<n;i++)
            perm[i]=i;
        while(1>0){
            ans+=1;
            for(int i=0;i<n;i++)
                if(i%2==0)
                    arr[i]=perm[i/2];
                else
                    arr[i]=perm[n/2+(i-1)/2];
            for(int i=0;i<n;i++)
                perm[i]=arr[i];
            boolean flag =true;
            for(int i=0;i<n;i++)
                if(perm[i]!=i){
                    flag=false;
                    break;
                }
            if(flag)
                return ans;
        }
    }
}