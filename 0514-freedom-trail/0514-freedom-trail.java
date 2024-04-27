class Solution {
    char arr[];
    int n,N,solved[][];
    HashMap<Character,ArrayList<Integer>> map;
    String key;
    public int find(int i,int p){
        if(i==n)
            return 0;
        else if(solved[i][p]!=-1)
            return solved[i][p];
        else if(arr[p]==key.charAt(i))
            return solved[i][p]=1+find(i+1,p);
        else{
            int ans=Integer.MAX_VALUE;
            for(int a:map.get(key.charAt(i))){
                int x=find(i+1,a);
                ans=Math.min(ans,1+Math.abs(a-p)+x);
                ans=Math.min(ans,1+Math.abs(N-Math.abs(a-p))+x);
            }
            return solved[i][p]=ans;
        }
    }
    public int findRotateSteps(String ring, String key) {
        n=key.length();
        N=ring.length();
        map= new HashMap<>();
        this.key=key;
        solved= new int[101][101];
        for(int x[]:solved) 
            Arrays.fill(x,-1);
        for(int i=0;i<ring.length();i++)
            if(map.get(ring.charAt(i))==null){
                map.put(ring.charAt(i),new ArrayList<Integer>());
                map.get(ring.charAt(i)).add(i);
            }
            else
                map.get(ring.charAt(i)).add(i);
        
        arr=ring.toCharArray();
        return find(0,0);
    }
}