class Solution {

    int[] arr;

    private int count(int root, HashMap<Integer, ArrayList<Integer>> list) {
        if(list.get(root).size() ==0) {
            arr[root] = 1;
            return 1;
        }

        int count = 0;

        for(int x: list.get(root)) count+=count(x,list);

        return arr[root] = count+1;
    }
    
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        arr = new int[n];
        HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();

        for(int i=0;i<n;i++) {
            list.put(i, new ArrayList<>());
        }

        list.put(-1, new ArrayList<>());

        for(int i=0;i<n;i++) {
            list.get(parents[i]).add(i);
        }

        count(0,list);

       long ans=0;
       int mx=0;

       for(int i=0;i<n;i++) {
            long temp=1;
            if(parents[i]!=-1) temp*=(arr[0] - arr[i]);
            for(int child: list.get(i)) temp*=arr[child];

            if(temp>ans) {
                ans = temp;
                mx = 1;
            } else if(temp == ans) mx++;
       }

       return mx;
    }
}