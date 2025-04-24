import java.util.*;

// Class to represent a Node in the graph
class Node {
    String id; // Unique identifier for the node
    String type; // Type of the node (e.g., "Product", "Category", "Customer", "Review")
    String name; // Name of the node
    Map<String, String> attributes; // Additional attributes (e.g., price, sentiment, etc.)

    public Node(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.attributes = new HashMap<>();
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}