class Solution {
    public String reversePrefix(String word, char ch) {
        int ind=0;
        for(int i=0;i<word.length();i++)
            if(word.charAt(i)==ch){
                ind=i;
                break;
            }
        char arr[]=word.toCharArray();
        int i=0;
        while(i<ind){
            ch=arr[i];
            arr[i]=arr[ind];
            arr[ind]=ch;
            i+=1;
            ind-=1;
        }
        return new String(arr);
    }
}