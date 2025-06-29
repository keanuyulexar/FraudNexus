from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

model = joblib.load('fraud_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json(force=True)
    amount = data.get('amount')
    location_score = data.get('location_score')
    device_score = data.get('device_score')
    features = np.array([[amount, location_score, device_score]])
    prediction = model.predict(features)[0]
    prob = model.predict_proba(features)[0][1]
    return jsonify({'is_fraud': int(prediction), 'fraud_probability': float(prob)})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
