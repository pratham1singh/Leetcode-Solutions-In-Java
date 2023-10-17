class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,0);
        
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1)
                map.put(leftChild[i],map.get(leftChild[i])+1);
            if(rightChild[i]!=-1)
                map.put(rightChild[i],map.get(rightChild[i])+1);
            
        }
        Queue<Integer> queue = new LinkedList<>();
        int l=0;
        for(int i=0;i<n;i++){
            if(map.get(i)==0&&l==0){
                queue.add(i);
                l+=1;
            }
            if(map.get(i)>1)
                return false;
        }
        
        while(l>0){
            int x=queue.remove();
            l-=1;
            n-=1;
            if(leftChild[x]!=-1){
                queue.add(leftChild[x]);
                l+=1;
            }
            if(rightChild[x]!=-1){
                queue.add(rightChild[x]);
                l+=1;
            }
        }
        System.out.println(n);
        return n==0;
        
    }
}