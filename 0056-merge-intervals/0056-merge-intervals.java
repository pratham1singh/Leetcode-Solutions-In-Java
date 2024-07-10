class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length,i=1;
        Stack<int[]> st = new Stack<>();
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        st.push(arr[0]);

        while(i<n){
            if(st.peek()[1]>=arr[i][0]){
                int a[]= new int[2];
                st.peek()[1]=Math.max(arr[i][1],st.peek()[1]);
                i++;
            }
            else{
                st.push(arr[i]);
                i++;
            }
        }
        int ans[][]= new int[st.size()][2];
        i=0;
        while(st.size()>0){
            ans[i][0]=st.peek()[0];
            ans[i][1]=st.peek()[1];
            st.pop();
            i++;
        }
        return ans;

    }
}