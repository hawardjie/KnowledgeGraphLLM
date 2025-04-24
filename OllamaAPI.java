// Utility class to interact with the Ollama API

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class OllamaAPI {
    public static String analyzeSentiment(String text) {
        try {
            // Set up the connection to the Ollama API
            URL url = new URL("http://localhost:5000/analyze-sentiment");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Send the review text as JSON
            String jsonInput = "{\"text\": \"" + text + "\"}";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                // Extract sentiment from the JSON response
                String sentiment = response.toString().split(":")[1].replace("}", "").replace("\"", "").trim();
                return sentiment;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }
}
