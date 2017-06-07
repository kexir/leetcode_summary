/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        // clone nodes
        int start = 0;
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while(start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for(UndirectedGraphNode neighbor: head.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        // clone neighbors
        for(int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode new_node = map.get(nodes.get(i));
            for(UndirectedGraphNode neighbor: nodes.get(i).neighbors) {
                new_node.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}