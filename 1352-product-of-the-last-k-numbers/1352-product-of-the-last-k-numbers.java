class ProductOfNumbers {

    ArrayList<Integer> arr, prod, z_count;
    int n;

    public ProductOfNumbers() {
       this.arr=new ArrayList<>();
       this.prod=new ArrayList<>();
       this.z_count=new ArrayList<>();
       this.n=0;

       this.prod.add(1);
       this.z_count.add(0);
    }
    
    public void add(int num) {
        this.n++;
        this.arr.add(num);
        this.prod.add(num==0? 1: this.prod.get(n-1)*num );
        this.z_count.add(this.z_count.get(n-1));

        if(num==0) this.z_count.set(n, this.z_count.get(n)+1);
    }
    
    public int getProduct(int k) {
        if(this.z_count.get(n)-this.z_count.get(n-k)>0) return 0;
        return this.prod.get(n)/this.prod.get(n-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */