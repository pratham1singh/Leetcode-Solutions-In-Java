class List2{
    int size;
    int arr[];
    List2(int n){
        this.size=n;
        this.arr=new int[n];
        
    }
}
class Allocator {
    List2 list1;
    public Allocator(int n) {
        list1=new List2(n);
    }
    
    public int allocate(int size, int mID) {
        
        int i=0,x=0,c=0;
        while(i<list1.size){
            
            if(c==size){
                break;
            }
            if(list1.arr[i]!=0){
                c=0;
                x=i+1;
            }
            else{
                c+=1;
            }
            i+=1;
        }
        if(c<size){
            return -1;
        }
        i=x;
        while(i<x+size){
            list1.arr[i]=mID;
            i+=1;
        }
        return x;
    }
    
    public int free(int mID) {
        int i=0,x=0;
        while(i<list1.size){
            if(list1.arr[i]==mID){
                list1.arr[i]=0;
                x+=1;
            }
            i+=1;
        }
        return x;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */