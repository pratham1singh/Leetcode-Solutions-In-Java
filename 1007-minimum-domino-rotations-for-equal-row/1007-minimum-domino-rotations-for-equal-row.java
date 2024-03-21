class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(tops[0],1);
        map.put(tops[1],1);
        for(int i=1;i<n;i++){
            if(tops[i]==bottoms[i]&&map.get(tops[i])!=null)
                map.put(tops[i],map.get(tops[i])+1);
            else{
                if(map.get(tops[i])!=null)
                    map.put(tops[i],map.get(tops[i])+1);
                if(map.get(bottoms[i])!=null)
                    map.put(bottoms[i],map.get(bottoms[i])+1);
            }
        }
        if(map.get(tops[0])<n&&map.get(bottoms[0])<n)
            return -1;
        int ans=0;
        for(int x:map.keySet()){
            if(map.get(x)<n)
                continue;
            int ans1=0,ans2=0;
            for(int i=0;i<n;i++){
                if(tops[i]!=x)
                    ans1+=1;
                if(bottoms[i]!=x)
                    ans2+=1;
            }
            ans=Math.min(ans1,ans2);
        }
        return ans;
    }
}