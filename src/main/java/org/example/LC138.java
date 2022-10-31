package org.example;

import java.util.HashMap;
import java.util.Map;

public class LC138 {
/**
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return createNewNode(head, map);
    }

    public Node createNewNode(Node oldNode, Map map) {

        if (oldNode == null) return null;

        if (map.containsKey(oldNode)) {
            return (Node) map.get(oldNode);
        }
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        newNode.next = createNewNode(oldNode.next, map);
        newNode.random = createNewNode(oldNode.random, map);

        return newNode;
    }
**/
}
