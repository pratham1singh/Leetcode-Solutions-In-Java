class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length,mn=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map1= new HashMap<>();
        HashMap<Integer,Integer> map2= new HashMap<>();

        for(int x:nums1)
            if(map1.get(x)==null)
                map1.put(x,1);
            else
                map1.put(x,map1.get(x)+1);
        for(int x:nums2)
            if(map2.get(x)==null)
                map2.put(x,1);
            else
                map2.put(x,map2.get(x)+1);

        for(int a:map1.keySet()){
            int diff=nums2[0]-a;
            boolean flag=true;
            for(int b:map2.keySet())
                if(map1.get(b-diff)==null||map2.get(b)!=map1.get(b-diff)){
                    flag=false;
                    break;
                }
            if(flag){
                mn=Math.min(mn,diff);
            }

        }
        return mn;
    }
}