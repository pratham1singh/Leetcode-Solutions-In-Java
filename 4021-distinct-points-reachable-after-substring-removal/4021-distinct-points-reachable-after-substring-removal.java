class Solution {
    public int getIndex(char ch) {
        switch(ch) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'R': return 3;
            default: return -1;
        }
    }
    public int distinctPoints(String s, int k) {
        int n = s.length(), i=0, j=0, ans=0;
        int[] count= new int[4];
        int[] tCount= new int[4];
        HashSet<String> set = new HashSet<>();

        while(j<n) tCount[getIndex(s.charAt(j++))]++;
        j=0;
        while(j<k) count[getIndex(s.charAt(j++))]++;
        j = k-1;
        while(j<n) {
            String str = (tCount[3] - count[3]) - (tCount[2] - count[2]) +" "+ ((tCount[0] - count[0]) - (tCount[1] - count[1]));
            if(!set.contains(str)) {
                set.add(str);
                ans++;
            }
            count[getIndex(s.charAt(i))]--;
            i++;
            j++;
            if(j<n) count[getIndex(s.charAt(j))]++;
        }
        return ans;
    }
}