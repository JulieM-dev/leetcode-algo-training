package com.mongault.leetcodetraining;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CloneGraphTraining {

    public static void main(String[] args) {

        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        ArrayList<Node> nodes = new ArrayList<>();

        for(int i = 0; i<adjList.length; i++) {
            nodes.add(new Node(i+1));
        }

        for(Node node: nodes) {
            for(int j=0; j<2; j++) {
                node.neighbors.add(nodes.get(adjList[node.val-1][j]-1));
            }
        }

        System.out.println(cloneGraph(nodes.get(0)));


    }



    public static Node cloneGraph(Node node) {
        if(node != null) {
            HashMap<Integer, Node> nodesCopies = new HashMap<>();
            Node result = new Node(node.val);
            nodesCopies.put(node.val, result);

            parcourirNode(node, result, new ArrayList<>(), nodesCopies);
            return result;
        }
        return null;
    }

    public static void parcourirNode(Node nodeAVisiter, Node nouveauNode, ArrayList<Node> nodesVisites, HashMap<Integer, Node> nodesCopies) {

        if(nodesVisites.contains(nodeAVisiter)) return;
        nodesVisites.add(nodeAVisiter);

        for(Node node : nodeAVisiter.neighbors) {
            if(!nodesVisites.contains(node)) {
                Node nouveauNodeNeighbor = new Node(node.val);
                nodesCopies.put(node.val, nouveauNodeNeighbor);
                parcourirNode(node, nouveauNodeNeighbor, nodesVisites, nodesCopies);
                nouveauNode.neighbors.add(nouveauNodeNeighbor);
            } else {
                nouveauNode.neighbors.add(nodesCopies.get(node.val));
            }

        }
    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

