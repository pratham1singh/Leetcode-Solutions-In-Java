class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[26], freq = new int[26];
        int n = s.length(), i=0, ans =-1, j=0;

        while(i<n) {
            freq[s.charAt(i) - 'a']++;
            i++;
        }
        i=n-1;

        while(i>=0) {
            if(freq[s.charAt(i)-'a']<k) {
                Arrays.fill(arr, 0);
                map.put(i, -1);
            } 
            else map.put(i, ++arr[s.charAt(i)-'a']);
            i--;
        }
        i=0;
        
        Arrays.fill(arr, 0);

        while(j<n) {
            if(map.get(j)==-1 || map.get(j)<k-arr[s.charAt(j)-'a']) {

                int mx =0;
                for(int x: arr) {
                    if(x!=0 && x<k) {
                        mx=0;
                        break;
                    } else mx+=x;
                }

                ans=Math.max(ans, mx);
                i=j + 1;
                Arrays.fill(arr,0);
            }
            else arr[s.charAt(j)-'a']++;
            j++;
        }
        ans=Math.max(ans, j-i <k ? 0 : j-i);
        
        return ans;
    }
}