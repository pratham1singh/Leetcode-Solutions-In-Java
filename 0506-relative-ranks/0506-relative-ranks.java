class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,String> map = new HashMap<>();
        String ans[]= new String[score.length];

        for(int x:score)
            pq.add(-x);
        map.put(-pq.poll(),"Gold Medal");
        if(pq.size()>0)
            map.put(-pq.poll(),"Silver Medal");
        if(pq.size()>0)
            map.put(-pq.poll(),"Bronze Medal");
        int k=4;
        while(pq.size()>0)
            map.put(-pq.poll(),""+(k++));
        for(int i=0;i<score.length;i++)
            ans[i]=map.get(score[i]);
        return ans;
    }
}