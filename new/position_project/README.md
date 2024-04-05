## API Endpoints Description

### 1. Fetch Positions based on AccountIds
- **Endpoint:** `http://localhost:8082/api/positions`
- **Input:** 
    ```json
    ["E1"]
    ```
- **Output:** 
    ```json
    [
        {
            "accountId": "E1",
            "positions": [
                {
                    "assetId": "S1",
                    "quantity": 100
                },
                {
                    "assetId": "S3",
                    "quantity": 100
                },
                {
                    "assetId": "S4",
                    "quantity": 100
                }
            ]
        }
    ]
    ```

