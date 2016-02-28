package com.shiping.leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 16/2/27.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
