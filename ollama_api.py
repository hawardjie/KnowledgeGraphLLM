from flask import Flask, request, jsonify
import subprocess

app = Flask(__name__)

@app.route('/analyze-sentiment', methods=['POST'])
def analyze_sentiment():
    data = request.json
    text = data.get("text", "")

    # Run Ollama CLI command
    result = subprocess.run(
        ["ollama", "run", "sentiment-analysis", text],
        stdout=subprocess.PIPE,
        text=True
    )

    # Extract sentiment from the output
    sentiment = result.stdout.strip().split(":")[-1].strip()
    return jsonify({"sentiment": sentiment})

if __name__ == '__main__':
    app.run(port=5000)
