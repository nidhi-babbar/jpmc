## API Endpoints Description

### 1. Calculate Collateral Value based on AccountIds
- **Endpoint:** `http://localhost:8080/api/collateral`
- **Input:** 
    ```json
    ["E1"]
    ```
- **Output:** 
    ```json
    [
        {
            "accountId": "E1",
            "collateralValue": 6876.00
        }
    ]
    ```