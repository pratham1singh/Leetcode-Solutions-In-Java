class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
 
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int ans=Integer.MAX_VALUE,k=1,dist=Integer.MAX_VALUE;
        while(node1!=-1&&map.get(node1)==null){
            map.put(node1,k++);
            node1= edges[node1];
        }
        k=1;

        while(node2!=-1&&set.contains(node2)==false){
            set.add(node2);
            // System.out.println("a");
            if(map.get(node2)!=null&&dist>Math.max(map.get(node2),k)){
                ans=node2;
                dist=Math.max(map.get(node2),k);
                
            }
            else if(map.get(node2)!=null&&dist==Math.max(map.get(node2),k))
                ans=Math.min(ans,node2);
            node2= edges[node2];
            k++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}