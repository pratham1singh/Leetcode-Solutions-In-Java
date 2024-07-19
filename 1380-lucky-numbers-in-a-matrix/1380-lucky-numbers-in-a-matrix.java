class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;

        ArrayList<Integer> row_min = new ArrayList<>();
        ArrayList<Integer> col_max = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            int mn=matrix[i][0];
            for(int j=0;j<n;j++)
                mn=Math.min(mn,matrix[i][j]);
            row_min.add(mn);
        }

        for(int i=0;i<n;i++){
            int mx=matrix[0][i];
            for(int j=0;j<m;j++)
                mx=Math.max(mx,matrix[j][i]);
            col_max.add(mx);
        }

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(matrix[i][j]==row_min.get(i)&&matrix[i][j]==col_max.get(j))
                    ans.add(matrix[i][j]);
        return ans;
        
    }
}