class Solution {
    int m,n;
    public int binToNum(int arr[]){
        int ans=0;

        for(int i=0;i<n;i++)
            ans+=arr[i]*(int)Math.pow(2,n-i-1);
    
        return ans;
    }
    public int matrixScore(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int  mask=0,arr[]= new int[m],count[]= new int[n];

        for(int i=n-1;i>=0;i--)
            mask+=(int)Math.pow(2,i);
        for(int i=0;i<m;i++)
            arr[i]=binToNum(grid[i]);
        for(int i=0;i<m;i++)
            arr[i]=Math.max((~arr[i])&mask,arr[i]);
        for(int a:arr){
            int i=0;
            while(a>0){
                if((a&1)==1)
                    count[i]+=1;
                i+=1;
                a=a>>1;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            System.out.println(count[i]+" k");
             if(count[i]>=Math.ceil((double)m/2)){
                ans+=count[i]*(int)Math.pow(2,i);
                // System.out.println(count[i]*(int)Math.pow(2,i));
            }
            else{
                ans+=(m-count[i])*(int)Math.pow(2,i);
                // System.out.println((m-count[i])*(int)Math.pow(2,i));
            }
        }
        return ans;
    }
}