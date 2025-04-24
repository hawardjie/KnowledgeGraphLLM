import java.util.*;

// Class to represent the Knowledge Graph
class KnowledgeGraph {
    Map<String, Node> nodes; // Stores nodes by their ID
    List<Edge> edges; // Stores edges

    public KnowledgeGraph() {
        this.nodes = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.put(node.id, node);
    }

    public void addEdge(String fromId, String toId, String relationship) {
        Node from = nodes.get(fromId);
        Node to = nodes.get(toId);
        if (from != null && to != null) {
            edges.add(new Edge(from, to, relationship));
        } else {
            System.out.println("Error: One or both nodes not found!");
        }
    }

    public void displayGraph() {
        System.out.println("Nodes:");
        for (Node node : nodes.values()) {
            System.out.println(node);
        }
        System.out.println("\nEdges:");
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
}