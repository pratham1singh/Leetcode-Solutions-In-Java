class Solution {
    int arr[],n,diff,visited[],solved[];
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int find(int i){
        if(map.get(arr[i]+diff)==null)
            return 0;
        else if(solved[i]!=-1)
            return solved[i];
        else{
            int ans=0;
            for(int ind:map.get(arr[i]+diff)){
                if(visited[ind]==0&&i<ind){
                    visited[ind]=1;
                    ans=Math.max(ans,1+find(ind));
                    visited[ind]=0;
                }
            }
            return solved[i]=ans;
        }
    }
    public int longestSubsequence(int[] arr, int difference) {
        n=arr.length;
        this.arr=arr;
        diff=difference;
        int ans=0;
        visited= new int[n];
        solved= new int[n];
        Arrays.fill(solved,-1);
        for(int i=0;i<n;i++)
            map.put(arr[i],new ArrayList<Integer>());
        for(int i=0;i<n;i++)
            map.get(arr[i]).add(i);

        for(int i=0;i<n;i++)
            if(visited[i]==0){
                visited[i]=1;
                // System.out.println(find(i));
                ans=Math.max(ans,1+find(i));
                visited[i]=0;
            }
        
        return ans;
    }
}