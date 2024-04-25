class Pair{
    String s;
    int t;
    public Pair(String s,int t){
        this.s=s;
        this.t=t;
    }
}
class Solution {
    HashMap<String,HashSet<String>> adj = new HashMap<>();
    HashMap<String,Boolean> map = new HashMap<>();
    HashMap<String,Boolean> visited = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=beginWord.length();
        char str[]= beginWord.toCharArray();
        for(String s:wordList)
            map.put(s,true);
        for(String s:wordList)
            adj.put(s,new HashSet<String>());
        adj.put(beginWord,new HashSet<String>());
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                str[i]=(char)(97+j);
                if(map.get(new String(str))!=null)
                    adj.get(beginWord).add(new String(str));
            }
            str[i]=beginWord.charAt(i);
        }
        for(String s:wordList){
            str=s.toCharArray();
            for(int i=0;i<n;i++){
                for(int j=0;j<26;j++){
                    str[i]=(char)(97+j);
                    if(map.get(new String(str))!=null)
                        adj.get(s).add(new String(str));
                }
                str[i]=s.charAt(i);
            }
        }
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        visited.put(beginWord,true);
        // System.out.println(adj);
        while(queue.size()>0){

            Pair z=queue.remove();
            if(z.s.compareTo(endWord)==0)
                return z.t;
            for(String a:adj.get(z.s))
                if(visited.get(a)==null){
                    visited.put(a,true);
                    queue.add(new Pair(a,z.t+1));
                }
        }
        
        return 0;
    }
}