class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length,i=0,j=n-1,score=0;
        Arrays.sort(tokens);

        while(i<=j){
            if(tokens[i]<=power){
                power-=tokens[i];
                score+=1;
                i+=1;
            }
            else if(i!=j&&tokens[j]+power>=tokens[i]&&score>0){
                score-=1;
                power+=tokens[j];
                j-=1;
            }
            else{
                break;
            }
        }
        return score;
    }
}