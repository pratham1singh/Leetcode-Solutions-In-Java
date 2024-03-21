class Solution {
    int n,visited[];
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();

    public boolean canTraverse(int i,int solved[]){
        if(map.get(i).size()==0){
            if(visited[i]==0)
                arr.add(i);
            return true;
        }
        boolean ans= true;
        for(int a:map.get(i)){
            if(solved[a]==1)
                return false;
            else if(visited[a]==0){
                visited[a]=1;
                solved[a]=1;
                ans =ans&&canTraverse(a,solved);
                solved[a]=0;
                arr.add(a);
            }
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n=numCourses;
        visited= new int[n];
        int list[]= new int[n];
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<Integer>());
        for(int x[]:prerequisites)
            map.get(x[0]).add(x[1]);
        boolean ans=true;
        for(int i=0;i<n;i++)
            if(ans&&visited[i]==0){
                visited[i]=1;
                int solved[]= new int[n];
                solved[i]=1;
                ans=ans&&canTraverse(i,solved);
                arr.add(i);
            }

        if(ans==false)
            return new int[0];
        int i=0;
        for(int x:arr){
            list[i]=x;
            i+=1;
        }
        return list;
    }
}