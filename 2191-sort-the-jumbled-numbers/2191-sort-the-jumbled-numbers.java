class Solution {
    class node{
        int old_val,new_val,ind;
        public node(int old_val,int new_val,int ind){
            this.old_val=old_val;
            this.new_val=new_val;
            this.ind=ind;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<node> pq = new PriorityQueue<>((p,q)->{
            if( p.new_val-q.new_val!=0)
                return p.new_val-q.new_val;
            else
                return p.ind-q.ind;
        });

        for(int i=0;i<nums.length;i++){
            int x=nums[i],new_val=0,temp=x;
            ArrayList<Integer> digit= new ArrayList<>();

            if(x==0)
                digit.add(mapping[0]);
            else
                while(x>0){
                    digit.add(0,mapping[x%10]);
                    x/=10;
                }
            for(int y:digit)
                new_val= new_val*10+y;
            // System.out.println(new_val);
            pq.add(new node(temp,new_val,i));
        }

        for(int i=0;i<nums.length;i++)
            nums[i]=(pq.poll()).old_val;
        return nums;
    }
}