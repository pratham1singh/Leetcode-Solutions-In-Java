class Node {
    int val, ind;

    Node(int ind, int val) {
        this.val = val;
        this.ind = ind;
    }
}

class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        int[] ans = new int[n];

        Arrays.fill(ans, 1);

        for(int i=0;i<n;i++) pq.add(new Node(i, arr[i]));

        while(pq.size() > 0) {
            Node node = pq.remove();
            int i = node.ind -1, j= node.ind, k = node.ind+1, mx =-1;

            if(i>=0 &&  arr[i] < arr[j]) {
                mx= ans[i] + 1;
            }

            if(k<n && arr[j] > arr[k]) {
                mx = Math.max(mx, ans[k] + 1);
            }
            
            if(mx!=-1)
                ans[j] = mx;
        }

        int temp = 0;

        for(int x: ans) temp+=x;
        return temp;
    }
}