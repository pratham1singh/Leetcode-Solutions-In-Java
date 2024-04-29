class Solution {
    int matrix[][],m,n;
    public int cal(ArrayList<Integer> arr){
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int x:arr)
            map.put(x,true);
        int c=0;
        for(int i=0;i<m;i++){
            boolean flag=true;
            for(int j=0;j<n;j++)
                if(matrix[i][j]==1&&map.get(j)==null){
                    flag=false;
                    break;
                }
            if(flag)
                c+=1;
        }

        return c;
                
    }
    public int find(int i,int numSelect,ArrayList<Integer> arr){
        if(i==n&&numSelect!=0)
            return Integer.MIN_VALUE;
        else if(i==n||numSelect==0)
            return cal(arr);
        else{
             int ans=Integer.MIN_VALUE;
             arr.add(i);
             ans=Math.max(ans,find(i+1,numSelect-1,arr));
             arr.remove(arr.size()-1);
             ans=Math.max(ans,find(i+1,numSelect,arr));
             return ans;
        }
    }
    public int maximumRows(int[][] matrix, int numSelect) {
        this.matrix=matrix;
        m=matrix.length;
        n=matrix[0].length;
        return find(0,numSelect,new ArrayList<>());
    }
}