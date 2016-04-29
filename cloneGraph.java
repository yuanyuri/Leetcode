/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// 1.clone node 2.clone node's neighbors
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        while (start < nodes.size()) {
        	UndirectedGraphNode head = nodes.get(start++);
        	for (int i = 0; i < head.neighbors.size(); i++) {
        		UndirectedGraphNode neighbor = head.neighbors.get(i);
        		if (!map.containsKey(neighbor)) {
        			map.put(neighbor, new UndirectedGraphNode(neighbor.label));
        			nodes.add(neighbor);
        		}
        	}
        }

        for (int i = 0; i < nodes.size(); i++) {
        	UndirectedGraphNode newNode = map.get(nodes.get(i));
       		for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
       			newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
        	}
        }
        return map.get(node);
    }
}