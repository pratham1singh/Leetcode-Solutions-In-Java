


class Trie {
   
    
    class Tree{
        Tree a[];
        boolean isEnd;
        public Tree(){
            a=new Tree[26];
            isEnd=false;
            int i=0;
            for(i=0;i<26;i++){
                this.a[i]=null;
            }
        }  
    }
    Tree root;
    public Trie() {
        root=new Tree();
            
    }
    
    public void insert(String word) {
        
        Tree temp=root;
            int l=word.length();
           
            for(int i=0;i<l;i++){
                if(temp.a[word.charAt(i)-97]==null){
                    Tree new1=new Tree();
                    
                    temp.a[word.charAt(i)-97]=new1;
                    temp=new1;

                }
                else{
                    temp=temp.a[word.charAt(i)-97];
                }
            }
            temp.isEnd=true;
            return;
    }
    
    public boolean search(String word) {
        Tree temp=root;
        for(int i=0;i<word.length();i++){
            if(temp.a[word.charAt(i)-97]==null)
                return false;
            else{
                temp=temp.a[word.charAt(i)-97];
            }
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Tree temp=root;
        for(int i=0;i<prefix.length();i++){
            if(temp.a[prefix.charAt(i)-97]==null)
                return false;
            else{
                temp=temp.a[prefix.charAt(i)-97];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */