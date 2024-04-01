class node{
    String str;
    int f;
    public node(String str,int f){
        this.str=str;
        this.f=f;
    }
}
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n=watchedVideos.size();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        queue.add(null);
        int visited[]= new int[n],l=0;
        visited[id]=1;
        while(queue.size()>1){
            if(l==level)
                break;
            // System.out.println(l+" "+queue);
            while(queue.peek()!=null){
                
                int x=queue.remove();
                for(int a:friends[x])
                    if(visited[a]==0){
                        visited[a]=1;
                        queue.add(a);
                    }
                // System.out.println(l+" "+queue);
            }
            // System.out.println(l+" "+queue);
            queue.remove();
            queue.add(null);
            l+=1;
            
        }
        
        HashMap<String,Integer> ans = new HashMap<>();
        HashMap<Integer,ArrayList<String>> sorted = new HashMap<>();
        ArrayList<Integer> freqs= new ArrayList<>();
        while(queue.size()>1){
            int x=queue.remove();
            for(String str:watchedVideos.get(x))
                if(ans.get(str)!=null)
                    ans.put(str,ans.get(str)+1);
                else
                    ans.put(str,1);
        }
        for(int x:ans.values())
            if(sorted.get(x)==null){
                sorted.put(x,new ArrayList<>());
                freqs.add(x);
            }
        
        for(String s:ans.keySet())
            sorted.get(ans.get(s)).add(s);
        for(int x:ans.values())
            Collections.sort(sorted.get(x));
        Collections.sort(freqs);
        
        List<String> arr = new ArrayList<>();
        for(int a:freqs)
            for(String str:sorted.get(a))
                arr.add(str);
        return arr;
    }
}