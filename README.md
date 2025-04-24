# Knowledge Graph LLM
Sentiment analysis using LLM and Knowledge Graph integration

Integrating the solution with Ollama (a platform for running and managing large language models locally) requires creating a custom LLM model for sentiment analysis and connecting it to the Java-based knowledge graph.

## Setup instructions

### Set Up Ollama
Install Ollama on your system by following the instructions from Ollama's official website.

Create a custom LLM model for sentiment analysis using Ollama's tools. This model will classify text into sentiments like "positive," "neutral," or "negative."

### Expose Ollama as an API
Ollama provides a CLI interface, but to integrate it with Java, you can expose it as an HTTP API using a lightweight server like Flask (Python) or FastAPI.

The API will accept review text as input and return the sentiment as output.

### Integrate the API with the Java Knowledge Graph

Use Java's HttpURLConnection or a library like OkHttp to send review text to the Ollama API and retrieve the sentiment.

### Update the Knowledge Graph
Dynamically update the review nodes in the graph with the sentiment returned by the Ollama model.

## Installation Steps

```
% ollama create sentiment-analysis -f Modelfile

// Optional: Delete existing model
% ollama rm sentiment-analysis 

% ollama run sentiment-analysis

// Test
% ollama run sentiment-analysis --format json "I got a bonus for my work."
{"positive":0,"neutral":1,"negative":0}

% ollama run sentiment-analysis --format json "I love her so much."
{"positive" : 1, "neutral" : 0, "negative" : 0}

// Install the required python env 
% conda env create -f environment.yml

// Activate the python env
% conda activate flask_env

// To deactivate
% conda deactivate

// Run the ollama model using python
% python ollama_api.py
 * Running on http://127.0.0.1:5000

// Compile the App
% javac App.java

// Run the App
% java App 
Nodes:
Node{id='R2', type='Review', name='Smartphone Review', attributes={sentiment=The text starts off with a somewhat lukewarm assessment (\okay\), which could be interpreted as neutral. However, the phrase \but the battery life is poor\ clearly conveys negative sentiment towards the phone. The use of the word \poor\ has a strong negative implication, implying that the battery life is subpar and not satisfactory.\n\nHow about you? Do you agree with my classification? What's your take on this text's sentiment? Let me know!, comment=The phone is okay, but the battery life is poor.}}
Node{id='P1', type='Product', name='Laptop', attributes={}}
Node{id='P2', type='Product', name='Smartphone', attributes={}}
Node{id='R1', type='Review', name='Laptop Review', attributes={sentiment=The text explicitly states that the product is \amazing\, which indicates a very positive sentiment., comment=This is an amazing product!}}

```

