package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidpy on 16/2/27.
 */
public class CloneGraph {
    Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        if(map.containsKey(node.label) == true) {
            return map.get(node.label);
        }
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(newnode.label, newnode);
        for(int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode neighbor = node.neighbors.get(i);
            newnode.neighbors.add(cloneGraph(neighbor));
        }
        return newnode;
    }
}
