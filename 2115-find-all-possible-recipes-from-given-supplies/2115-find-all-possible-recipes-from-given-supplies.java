class Solution {
    HashMap<String,ArrayList<String>> adj = new HashMap<>();
    HashMap<String,Integer> indegree = new HashMap<>();
    HashMap<String,Boolean> visited= new HashMap<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        for(int i=0;i<n;i++)
            for(String str:ingredients.get(i)){
                if(adj.get(str)!=null)
                    adj.get(str).add(recipes[i]);
                else{
                    adj.put(str,new ArrayList<String>());
                    adj.get(str).add(recipes[i]);
                }
                if(indegree.get(recipes[i])==null)
                    indegree.put(recipes[i],0);
                indegree.put(recipes[i],indegree.get(recipes[i])+1);
            }
        // System.out.println(indegree);
        Queue<String> queue = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        for(String s:supplies)
            queue.add(s);
        
        while(queue.size()>0){
            String s=queue.remove();
            visited.put(s,true);
            if(adj.get(s)!=null)
                for(String a:adj.get(s))
                    if(indegree.get(a)==1)
                        queue.add(a);
                    else
                        indegree.put(a,indegree.get(a)-1);
        }
        System.out.println(indegree);
        for(String s:recipes)
            if(visited.get(s)!=null)
                ans.add(s);
        return ans;
    }
}