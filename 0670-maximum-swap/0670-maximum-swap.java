class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n=0;
        boolean flag=true;

        while(num>0){
            arr.add(0,num%10);
            num=num/10;
            n+=1;
        }
        for(int i=0;i<n;i++){
            int mx=-1,ind=-1;
            for(int j=n-1;j>i;j--){
                if(arr.get(i)<arr.get(j)&&mx<arr.get(j)){
                    mx=arr.get(j);
                    ind=j;
                    flag=false;
                }
            }
            if(!flag){
                arr.set(ind,arr.get(i));
                arr.set(i,mx);
                flag=false;
                break;
            }
        }
        num=0;
        for(int i=0;i<n;i++)
            num=num*10+arr.get(i);
        return num;
    }
}