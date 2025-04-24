public class App {
    public static void main(String[] args) {
        KnowledgeGraph graph = new KnowledgeGraph();

        // Create product nodes
        Node product1 = new Node("P1", "Product", "Laptop");
        Node product2 = new Node("P2", "Product", "Smartphone");

        // Create review nodes with comments
        Node review1 = new Node("R1", "Review", "Laptop Review");
        review1.addAttribute("comment", "This is an amazing product!");

        Node review2 = new Node("R2", "Review", "Smartphone Review");
        review2.addAttribute("comment", "The phone is okay, but the battery life is poor.");

        // Perform sentiment analysis using Ollama API
        String sentiment1 = OllamaAPI.analyzeSentiment(review1.attributes.get("comment"));
        String sentiment2 = OllamaAPI.analyzeSentiment(review2.attributes.get("comment"));

        // Add sentiment to review nodes
        review1.addAttribute("sentiment", sentiment1);
        review2.addAttribute("sentiment", sentiment2);

        // Add nodes to the graph
        graph.addNode(product1);
        graph.addNode(product2);
        graph.addNode(review1);
        graph.addNode(review2);

        // Display the graph
        graph.displayGraph();
    }
    
}
