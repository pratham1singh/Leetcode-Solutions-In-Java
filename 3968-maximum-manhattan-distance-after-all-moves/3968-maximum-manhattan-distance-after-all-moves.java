class Solution {
    public int maxDistance(String str) {
        int a=0, b=0, e =0;

        for(char ch: str.toCharArray()) {
            if(ch == 'U') a++;
            else if(ch == 'D') a--;
            else if(ch == 'L') b++;
            else if (ch == 'R') b--;
            else e++;
        }

        return Math.abs(a) + Math.abs(b) + e;

    }
}