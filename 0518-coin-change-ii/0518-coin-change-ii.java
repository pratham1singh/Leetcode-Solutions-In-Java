//Exhaustive Search
class Solution1 {
    ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    int n,amount;
    public void generate(int i,ArrayList<Integer> list1,int val,int arr[]){
        if(i>=n||val>=amount)
            subsets.add(list1);
        else{
            ArrayList<Integer> without= new ArrayList<>(list1);
            generate(i+1,without,val,arr);
            ArrayList<Integer> with= new ArrayList<>(list1);
            with.add(arr[i]);
            generate(i,with,val+arr[i],arr);

        }
    }
    public boolean is_valid(ArrayList<Integer> list1){
        int s=0;
        for(int x:list1)
            s+=x;
        return s==amount;
    }
    public int change(int amount, int[] coins) {
        ArrayList<Integer> l= new ArrayList<>();
        int ans=0;
        this.amount=amount;
        this.n=coins.length;
        generate(0,l,0,coins);
        for(ArrayList<Integer>subset:subsets){
            if(is_valid(subset))
                ans+=1;
        }
        return ans;
    }
}
//Backtracking with pruning
class Solution2 {
    ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    int n,amount,ans=0;
    public void generate(int i,ArrayList<Integer> list1,int val,int arr[]){
       if(val==amount){
           System.out.println(list1);
           subsets.add(new ArrayList<>(list1));
           ans+=1;
       }
       
       else if(i>=n||val>amount)
            return;
        else{
            //without
            generate(i+1,list1,val,arr);
            //with
            list1.add(arr[i]);
            generate(i,list1,val+arr[i],arr);
            list1.remove(list1.size()-1);

        }
        
    }
    
    public int change(int amount, int[] coins) {
        ArrayList<Integer> l= new ArrayList<>();
        this.amount=amount;
        this.n=coins.length;
        generate(0,l,0,coins);
        return ans;
    }
}

//Bottom Up Naive Recursion
class Solution3 {
    int n,amount,ans=0;
    public int generate(int i,int val,int arr[]){
       if(val==amount){
           return 1;
       }
       
       else if(i>=n||val>amount)
            return 0;
        else{
            int without=generate(i+1,val,arr);
            int with=generate(i,val+arr[i],arr);
            return without+with;
        }
        
    }
    
    public int change(int amount, int[] coins) {
        this.amount=amount;
        this.n=coins.length;
        return generate(0,0,coins);
    }
}

//Recursion + Memorization
class Solution {
    int n,amount,ans=0,visited[][];
    public int generate(int i,int val,int arr[]){
       if(val==amount){
           return 1;
       }
       else if(i>=n||val>amount)
            return 0;
       else if(visited[i][val]!=-1)
        return visited[i][val];
       
        else{
            int without=generate(i+1,val,arr);
            int with=generate(i,val+arr[i],arr);
            visited[i][val]=without+with;
            return visited[i][val];
        }
        
    }
    
    public int change(int amount, int[] coins) {
        this.amount=amount;
        this.n=coins.length;
        this.visited= new int[n+1][amount+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<=amount;j++)
                visited[i][j]=-1;
        return generate(0,0,coins);
    }
}

