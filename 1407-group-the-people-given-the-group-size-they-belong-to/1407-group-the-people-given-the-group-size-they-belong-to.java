class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // System.out.println(map);
            if(map.get(arr[i])!=null){
                if(map.get(arr[i]).size()<arr[i])
                    map.get(arr[i]).add(i);
                else{
                    ans.add(map.get(arr[i]));
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    map.put(arr[i],a);
                }
            }
            else{
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    map.put(arr[i],a);
            }
        }
        for(List<Integer> a:map.values()){
            ans.add(a);
        }
        return ans;
    }
}