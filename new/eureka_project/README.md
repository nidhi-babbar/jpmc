## API Endpoints Description

### 1. Fetch Prices Based on AssetIds
- **Endpoint:** `http://localhost:8080/prices`
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

### 2. Fetch Positions based on AccountIds
- **Endpoint:** `http://localhost:8080/positions`
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

### 3. Check Eligibility based on AccountIds & AssetIds
- **Endpoint:** `http://localhost:8080/eligibility`
- **Assumption:** Assuming list of eligibilities saved in DB ,based on accountids and assetids,filtering the eligibility list.
- **Input:** 
    ```json
    {
      "accountIds": ["E1"],
      "assetIds": ["S1","S3"]
    }
    ```
- **Output:** 
    ```json
    [
        {
            "eligible": true,
            "assetIds": ["S1", "S3", "S4"],
            "accountIds": ["E1"],
            "discount": 0.9
        }
    ]
    ```

### 4. Calculate Collateral Value based on AccountIds
- **Endpoint:** `http://localhost:8080/collateral`
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