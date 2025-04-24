// Class to represent an Edge in the graph
class Edge {
    Node from;
    Node to;
    String relationship; // Relationship type (e.g., "belongs_to", "reviewed_by", "has_sentiment")

    public Edge(Node from, Node to, String relationship) {
        this.from = from;
        this.to = to;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from.name +
                ", to=" + to.name +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}