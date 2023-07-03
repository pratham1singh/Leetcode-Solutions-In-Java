class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int n=A.length,i=0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int ans[] = new int[n];
        while(i<n){
            if(map1.get(A[i])==null)
                map1.put(A[i],1);
            else
                map1.put(A[i],map1.get(A[i])+1);

            if(map2.get(B[i])==null)
                map2.put(B[i],1);
            else
                map2.put(B[i],map2.get(B[i])+1);
            int c=0;
            for(int x:map1.keySet()){
                if(map2.get(x)!=null)
                    c+=1;
            }
            ans[i]=c;
            i+=1;
            

        }
        return ans;
    }
}