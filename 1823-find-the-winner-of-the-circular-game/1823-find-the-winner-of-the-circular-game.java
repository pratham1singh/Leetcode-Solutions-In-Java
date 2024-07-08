//Solution1 using simple array
class Solution {
    public int findTheWinner(int n, int k) {
        int arr[]= new int[n],i=0,c=n;

        while(c>1){
            int j=i,count=0;
            if(j==n)
                j=0;

            while(1>0){
                if(arr[j]!=-1)
                    count+=1;
                if(count==k)
                    break;
                if(j==n-1)
                    j=0;
                else
                    j+=1;
                // if(j==i)
                //     break;
            }
            if(count<k)
                break;
            i=j;
            System.out.println(i);
            arr[i]=-1;
            i++;
            if(i==n)
                i=0;
            c-=1;
        }
        i=0;
        while(arr[i]==-1)
            i++;
        return i+1;


    }
}