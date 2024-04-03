http://localhost:8080/prices
input - ["S1", "S2", "S3"] -- based on assetid, it will fetch the list of assetid and price.
output-[
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


http://localhost:8080/positions
input-["E1"]-- -- based on accountId, it will fetch the list of positions.
output-[
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


http://localhost:8080/eligibility  
input- Assumed there is a eligibility list, where input account ids and asset ids matched , putting that object in eligibility list.
{
  "accountIds": ["E1"],
  "assetIds": ["S1","S3"]
}
output-[
    {
        "eligible": true,
        "assetIds": [
            "S1",
            "S3",
            "S4"
        ],
        "accountIds": [
            "E1"
        ],
        "discount": 0.9
    }
]


http://localhost:8080/collateral
input ["E1"]
output- [
    {
        "accountId": "E1",
        "collateralValue": 6876.00
    }
]