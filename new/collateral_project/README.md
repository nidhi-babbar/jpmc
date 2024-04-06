## API Endpoints Description

### 1. Calculate Collateral Value based on AccountIds
- **Endpoint:** `http://localhost:8080/api/collateral`
- **Comments:** `Implemented circuit breaker pattern  and feign client to communicate different microservices. `
- **Improvement:** `DRY principal violated in circuit breaker pattern , need to remove duplicate code to handle DRY principal `
- **Input:** 
    ```json
    ["E1"]
    ```
- **Output:** 
    ```json
    [
        {
            "accountId": "E1",
           "collateralValue": 5481.00
        }
    ]
    ```