class Solution {
    int tokens[],power,n;
    public int find(int i,int power){
        if(i==n)
            return 0;
        else if(tokens[i]<=power)
            return 1+find(i+1,power-tokens[i]);
        else {
            return Math.max(find(i+1,power+tokens[i])-1,find(i+1,power));
        }   
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        this.tokens=tokens;
        n=tokens.length;
    }
}