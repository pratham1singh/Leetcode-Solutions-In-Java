class Solution {
    ArrayList<String> ans = new ArrayList<>();
    int K;
    public void perm(int arr[],int n,String s){
        if(ans.size()<=K){
            if(n==0){
          
            ans.add(s);
        }
        else{
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=-1){
                    // list1.add(arr[i]);
                    int x=arr[i];
                    arr[i]=-1;
                    perm(arr,n-1,s+x);
                    arr[i]=x;
                    // list1.remove(l);
                }
            }
        }
        }
    }
    public String getPermutation(int n, int k) {
        int arr[]= new int[n];
        K=k;
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        String s="";
        perm(arr,n,s);
        
        return ans.get(k-1);
    }
}