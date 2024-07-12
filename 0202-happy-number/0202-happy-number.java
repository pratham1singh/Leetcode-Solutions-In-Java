class Solution {
    public int digitSum(int n){
        int sum=0;

        while(n>0){
            int d=n%10;
            sum+=(d*d);
            n=n/10;
        }
        return sum;

    }
    public boolean isHappy(int n) {
        HashMap<Integer,Boolean> map = new HashMap<>();

        while(n!=1&&map.get(n)==null){
            map.put(n,true);
            n=digitSum(n);
            // System.out.println(n);
            
        }
        return n==1;
    }
}