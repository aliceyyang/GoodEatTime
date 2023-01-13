# API Document 

1. Returns json data about all the ad orders from admin's perspective.
	
	-   **URL**
	    
		   /adOrders/admin
	    
	-   **Method:**
	    
	    `GET`
	    
	-   **URL Params**
	    
	    **Required:**
	    
	    None
	    
	-   **Body Params**
	    
	    None
	    
	-   **Success Response:**
	    
	    -   **Code:**  200  
	        **Content:** returns json data about all the ad orders
			```
			[
				{
					"adOrderNo": 1, 
					"restaurantNo": 1,
					"adminNo": 3,
					"adOrderTime": "2022-10-31 15:18:08",
					"adStartTime": "2022-11-01 00:00:00",
					"adEndTime": "2022-11-08 00:00:00",
					"verified": true,
					"verificationDetail": "開幕廣告(急件)",
					"adOrderPrice": 1000
				}
			]
			```


	-   **Error Response:**
	    
	    -   **Code:**  404 NOT FOUND  
	        **Content:**  `{ error : "Not Found" }`


