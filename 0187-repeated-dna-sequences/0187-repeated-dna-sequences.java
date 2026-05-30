class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> included = new HashSet<>();
        List<String> ans = new ArrayList<>();

        int i=0, j=9;

        while(j<n) {
            String str = s.substring(i,j+1);
            if(set.contains(str) && !included.contains(str)) {
                ans.add(str);
                included.add(str);
            }
            else set.add(str);

            i++;
            j++;
        }

        return ans;
    }
}