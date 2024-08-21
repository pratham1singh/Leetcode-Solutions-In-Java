class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Integer> strings = new ArrayList<>();
        int arr[]= new int[26];
        
        for(String s:words){
            for(int i=0;i<s.length();i++)
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            strings.add(s.length());
        }
        Collections.sort(strings);

        for(char ch='a';ch<='z';ch++)
            arr[(int)(ch-97)]=map.getOrDefault(ch,0);

        int ans=0;
        for(int x:strings){
            int n=x,i=0,j=x-1;
            boolean flag=true;
            while(i<j){
                boolean flag2=false;
                for(int k=0;k<26;k++)
                    if(arr[k]>=2){
                        arr[k]-=2;
                        flag2=true;
                        break;
                    }
                if(flag2==true){
                    i++;
                    j--;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag==false) continue;
            if(i>j){
                ans++;
                continue;
            }
            boolean temp=false;
            for(int k=0;k<26;k++)
                if(arr[k]%2==1){
                    ans++;
                    arr[k]-=1;
                    temp=true;
                    break;
                }
            if(temp==false)
                for(int k=0;k<26;k++)
                    if(arr[k]>=1){
                        ans++;
                        arr[k]-=1;
                        temp=true;
                        break;
                    }
        }
        // System.out.println(map);
        return ans;
    }
}