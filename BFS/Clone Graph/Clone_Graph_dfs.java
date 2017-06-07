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
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraphHelper(node, map);
    }
    public UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraphHelper(neighbor, map));
        }
        return newNode;
    }
}