class Solution {
    private class Node {
        char ch;
        int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<n;i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(Character ch: map.keySet()) pq.add(new Node(ch, map.get(ch)));
        
        while(pq.size() > 0) {
            Node temp = pq.remove();

            while(temp.count-- >0) ans.append(temp.ch);
        }

        return ans.toString();

    }
}