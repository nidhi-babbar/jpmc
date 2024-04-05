## API Endpoints Description


### 1. Check Eligibility based on AccountIds & AssetIds
- **Endpoint:** `http://localhost:8083/api/eligibility`
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

