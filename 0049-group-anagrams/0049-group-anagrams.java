class Solution {

    public String sort(String str) {
        String ans = "";
        int n = str.length();
        int[] arr = new int[26];

        for(int i=0;i<n;i++){
            arr[str.charAt(i) - 97]+=1;
        }
        for(int x: arr) ans= ans + "--" + x;
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            String s1 = this.sort(s);
            List<String> list = map.getOrDefault(s1, new ArrayList<>());
            list.add(s);
            map.put(s1, list);
        }

        return new ArrayList<>(map.values());
    }
}