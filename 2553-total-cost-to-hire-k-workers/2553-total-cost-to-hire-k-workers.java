class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        if(n==1)
            return costs[0];
        long ans=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        HashMap<Integer,Integer> mapi=new HashMap<>();
        HashMap<Integer,Integer> mapj=new HashMap<>();
        int i=0,j=n-1;
        while(i<candidates&&i<j){
            if(mapi.get(costs[i])!=null)
                mapi.put(costs[i],mapi.get(costs[i])+1);
            else
                mapi.put(costs[i],1);
            if(mapj.get(costs[j])!=null)
                mapj.put(costs[j],mapj.get(costs[j])+1);
            else
                mapj.put(costs[j],1);

            queue.add(costs[i]);
            queue.add(costs[j]);
            i+=1;
            j-=1;
        }
        while(k>0){
            int x=queue.poll();
            
            if(mapi.get(x)!=null&&mapi.get(x)>0){
               mapi.put(x,mapi.get(x)-1);
                
                if(i<=j&&i<n){
                    
                    queue.add(costs[i]);
                    if(mapi.get(costs[i])!=null)
                        mapi.put(costs[i],mapi.get(costs[i])+1);
                    else
                        mapi.put(costs[i],1);
                i+=1;
                }
            
            ans+=x;
            k-=1;
                
            }
            else if(mapj.get(x)>0){
                 mapj.put(x,mapj.get(x)-1);
                
                if(i<=j&&j>=0){
                    
                     queue.add(costs[j]);
                     if(mapj.get(costs[j])!=null)
                        mapj.put(costs[j],mapj.get(costs[j])+1);
                    else
                        mapj.put(costs[j],1);
                 j-=1;
                }
                 
                 ans+=x;
                k-=1;
            }

        }
        return ans;
    }
}