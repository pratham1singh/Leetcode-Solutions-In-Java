class Solution {
    public boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i+=1;
            j-=1;
        }
        return true;
    }
    public boolean checkPalindromeFormation(String a, String b) {
        int l1=a.length(),l2=b.length();
        if(isPalin(a)||isPalin(b))
            return true;
        int i=0,j=l2-1;
        while(a.charAt(i)==b.charAt(j)&&i<j){
            i+=1;
            j-=1;
        }
        if(i-1==j)
            return true;
        if(i<j&&(isPalin(b.substring(i,j+1))||isPalin(a.substring(i,j+1))))
            return true;
        i=l1-1;
        j=0;
        while(a.charAt(i)==b.charAt(j)&&j<i){
            i-=1;
            j+=1;
        }
        System.out.println(i+" "+j);
        if(j-1==i)
            return true;
        if(j<i&&(isPalin(a.substring(j,i+1))||isPalin(b.substring(j,i+1))))
            return true;
        return false;
    }
}