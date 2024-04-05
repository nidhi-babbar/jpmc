## API Endpoints Description

### 1. Fetch Prices Based on AssetIds
- **Endpoint:** `http://localhost:8081/api/prices`
- **Input:** 
    ```json
    ["S1", "S2", "S3"]
    ```
- **Output:** 
    ```json
    [
        {
            "assetId": "S1",
            "price": 50.5
        },
        {
            "assetId": "S2",
            "price": 20.2
        },
        {
            "assetId": "S3",
            "price": 10.4
        }
    ]
    ```

