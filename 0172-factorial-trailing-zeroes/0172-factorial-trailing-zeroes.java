class Solution {
    public int trailingZeroes(int n) {
        int two=0,five=0;
        for(int i=2;i<=n;i++){
            int num=i;
            while(num%2==0){
                two+=1;
                num=num/2;
            }
            while(num%5==0){
                five+=1;
                num=num/5;
            }
        }
        // System.out.println(two++fi)
        return Math.min(two,five);
    }
}