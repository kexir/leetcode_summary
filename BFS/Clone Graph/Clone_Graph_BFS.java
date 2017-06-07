class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        map.put(node.label, new_node);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            for(UndirectedGraphNode neighbor : temp.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(temp.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return new_node;
    }
}