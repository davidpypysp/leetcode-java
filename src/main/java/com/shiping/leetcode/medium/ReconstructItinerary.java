package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by davidpy on 2/29/16.
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        String[][] tickets = new String[][]{
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        };
        new ReconstructItinerary().findItinerary(tickets);

    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<String>();
        if(tickets.length == 0) return list;
        int len = tickets.length;
        List<Edge> array = new ArrayList<Edge>();
        Map<String, Node> map = new HashMap<String, Node>();
        Node firstnode = new Node("JFK");
        map.put("JFK", firstnode);
        for(int i = 0; i < len; i++) {
            Node start, end;
            if(map.containsKey(tickets[i][0]) == false) {
                start = new Node(tickets[i][0]);
                map.put(tickets[i][0], start);
            }
            else {
                start = map.get(tickets[i][0]);
            }
            if(map.containsKey(tickets[i][1]) == false) {
                end = new Node(tickets[i][1]);
                map.put(tickets[i][1], end);
            }
            else {
                end = map.get(tickets[i][1]);
            }
            Edge e = new Edge(start, end);
            array.add(e);
        }
        Collections.sort(array, new EdgeComparator());
        for(int i = 0; i < len; i++) {
            Edge e = array.get(i);
            Node start = e.start;
            Node end = e.end;
            start.edges.add(e);
        }
        Map<Edge, Boolean> vis = new HashMap<Edge, Boolean>();
        list.add("JFK");
        dfs(firstnode, vis, list, 0, len);
        return list;
    }


    boolean dfs(Node node, Map<Edge, Boolean> vis, List<String> ans, int cur, int len) {
        if(cur == len) return true;
        boolean flag = false;
        for(int i = 0; i < node.edges.size(); i++) {
            Edge e = node.edges.get(i);
            if(vis.containsKey(e) == false || vis.get(e) == false) {
                vis.put(e, true);
                ans.add(e.end.name);
                if(dfs(e.end, vis, ans, cur + 1, len) == true) return true;
                vis.put(e, false);
                ans.remove(ans.size() - 1);
            }

        }
        return false;
    }

    class Node {
        String name;
        List<Edge> edges;
        Node(String name) {
            this.name = name;
            edges = new ArrayList<Edge>();
        }
    }

    class Edge {
        Node start;
        Node end;
        Edge(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return e1.end.name.compareTo(e2.end.name);
        }
    }
}
