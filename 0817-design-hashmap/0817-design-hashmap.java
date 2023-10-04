class MyHashMap {
    int map[];
    public MyHashMap() {
        int size=(int)Math.pow(10,6)+1;
        this.map= new int[size];
        for(int i=0;i<size;i++)
            this.map[i]=-1;
    }
    
    public void put(int key, int value) {
        this.map[key]=value;
    }
    
    public int get(int key) {
        return this.map[key];
    }
    
    public void remove(int key) {
        this.map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */