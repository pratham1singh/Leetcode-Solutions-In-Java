
class Solution {
    int a[][];
    
    public int cal(int ind,int arr[],int s){
        if(ind==0){
            if(s%arr[ind]==0)
                return 1;
            else
                return 0;
        }
        else if(s==0){
            return 1;
        }
        else{
            if(arr[ind]<=s){
                if(a[s][ind]!=-1)
                    return a[s][ind];
                else{
                    a[s][ind]=cal(ind-1,arr,s)+cal(ind,arr,s-arr[ind]);
                    return a[s][ind];
                }
                

            }
            else{
                 if(a[s][ind]!=-1)
                    return a[s][ind];
                else{
                    a[s][ind]=cal(ind-1,arr,s);
                    return a[s][ind];
                }
            }
        }
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        a=new int[amount+1][n+1];
        for(int i=0;i<=amount;i++){
            for(int j=0;j<=n;j++)
                a[i][j]=-1;
        }
        return cal(n-1,coins,amount);
    }
}