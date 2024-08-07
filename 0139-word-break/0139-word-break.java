class node{

            node [] a=new node [26];
            boolean isEnd;

            node (){

                this.isEnd=false;
                int i=0;
                for(i=0;i<26;i++){
                    this.a[i]=null;
                }
            }
    }
class Trie{

    
            
    node root=new node();

    void insert(String str1){
        node temp=root;
        int l=str1.length();
    
        for(int i=0;i<l;i++){
            if(temp.a[str1.charAt(i)-97]==null){
                node new1=new node();
                
                temp.a[str1.charAt(i)-97]=new1;
                temp=new1;

            }
            else{
                temp=temp.a[str1.charAt(i)-97];
            }
        }
        temp.isEnd=true;
        return;
    }

    boolean isthere(String str1){

        node temp=root;
        int l=str1.length();
        for(int i=0;i<l;i++){
            if(temp.a[str1.charAt(i)-97]==null){
                return false;
            }
            else{
                temp=temp.a[str1.charAt(i)-97];
            }
        }
        return temp.isEnd;
    }


}
    
    
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

            Trie t=new Trie();
            for(int i=0;i<wordDict.size();i++){
                t.insert(wordDict.get(i));
            }
            int i=0,j=-1;
            while(i<s.length()){
                node temp=t.root;
                while(i<s.length()&&temp!=null&&temp.a[s.charAt(i)-97]!=null){
                    temp=temp.a[s.charAt(i)-97];
                    j+=1;
                    i+=1;
                    
                }
                //  System.out.println(i);
                if(temp.isEnd==true)
                    continue;
                else
                    return false;

            }
           
            return j==s.length()-1;
        
    }
}