# Ad Order Management
We provide restaurants to promote their specials and center on the homepage in one of our rotating carousel slots. The table below shows the duration of ADs that Good Eat Time has offered:


| Plan | Duration | Price (NTD)
| :--- | :--- |  :--- | 
| A| `a week` | $ 1,000
| B | `a month` | $ 2,000
| C | `a season` | $ 3,000
| D | `a year` | $ 4,000
<br>
<br>

Restaurants can change their campaign advertise pictures and the start-date multiple times before our platform admin verifies the order. After verification has been done, the ad will automatically shows on our homepage.
<br>


### AdOrders have the following format:
```JSON

{
	  "adOrderNo"			: 1,
	  "restaurantNo"		: 1,
	  "adminNo"			: 3,
	  "adOrderTime"			: "2022-10-31 15:18:08",
	  "adStartTime"			: "2022-11-01 00:00:00",
	  "adEndTime"			: "2022-11-08 00:00:00",
	  "verified"			: true,
	  "verificationDetail"		: "開幕廣告(急件)",
	  "adOrderPrice"		: 1000,
	  "slideshowPic"		: null
}
```
<br>
<br>

## AdOrder - Restaurant perspective
| URL | method | **Description** |
| :--- | :--- | :--- |
| /adOrders | `POST` | create an order |
| /adOrders/restaurantNo/{restaurantNo} | `GET` | get order list of a restaurant |
| /adOrders/restaurant/{adOrderNo} | `PUT` | update an order (before verification)|
| /adOrders/{adOrderNo} | `DELETE` | cancel an order (before verification)|


```JSON 
// create an order
{
	  "restaurantNo"		: 4,
	  "adStartTime"			: "2023-06-01 00:00:00",
	  "adEndTime"			: "2023-06-30 00:00:00",
	  "adOrderPrice"		: 2000,
	  "slideshowPicBase64"		: "[base64]"
}
```
```JSON 
// get order list of a restaurant
[
  {
	    "adOrderNo"			: 4,
	    "restaurantNo"		: 4,
	    "adminNo"			: 2,
	    "adOrderTime"		: "2022-11-10 15:18:08",
	    "adStartTime"		: "2023-03-01 00:00:00",
	    "adEndTime"			: "2023-04-01 00:00:00",
	    "verified"			: true,
	    "verificationDetail"	: "開幕廣告(月)",
	    "adOrderPrice"		: 2000,
	    "slideshowPic"		: "[base64]"
  },
  {
	    "adOrderNo"			: 15,
	    "restaurantNo"		: 4,
	    "adminNo"			: null,
	    "adOrderTime"		: "2023-01-02 19:15:34",
	    "adStartTime"		: "2023-03-03 00:00:00",
	    "adEndTime"			: "2023-06-03 00:00:00",
	    "verified"			: null,
	    "verificationDetail"	: null,
	    "adOrderPrice"		: 3000,
	    "slideshowPic"		: "[base64]"
  }
]
```
```JSON
// update an order
{
	  "adOrderNo"			: 15,
	  "adStartTime"			: "2024-07-01 00:00:00",
	  "adEndTime"			: "2024-10-01 00:00:00",
	  "adOrderPrice"		: 3000,
	  "slideshowPicBase64"		: "[base64]"
}
```
<br>
<br>

## AdOrder - Administrator perspective
| URL | method | **Description** |
| :--- | :--- | :--- |
| /adOrders/admin | `GET` | get order list of all restaurants |
| /adOrders/admin/{adOrderNo} | `PUT` | update an order|
| /adOrders/{adOrderNo} | `DELETE` | cancel an order|
```JSON
// get order list of all restaurants
[
  {
	    "adOrderNo"			: 1,
	    "restaurantNo"		: 1,
	    "adminNo"			: 3,
	    "adOrderTime"		: "2022-10-31 15:18:08",
	    "adStartTime"		: "2022-11-01 00:00:00",
	    "adEndTime"			: "2022-11-08 00:00:00",
	    "verified"			: true,
	    "verificationDetail"	: "開幕廣告(急件)",
	    "adOrderPrice"		: 1000,
	    "slideshowPic"		: "[base64]"
  },
  {
	    "adOrderNo"			: 2,
	    "restaurantNo"		: 2,
	    "adminNo"			: 1,
	    "adOrderTime"		: "2022-10-31 15:18:08",
	    "adStartTime"		: "2023-01-01 00:00:00",
	    "adEndTime"			: "2023-02-01 00:00:00",
	    "verified"			: true,
	    "verificationDetail"	: "開幕廣告(月)",
	    "adOrderPrice"		: 2000,
	    "slideshowPic"		: "[base64]"
  }
]
```
```JSON
// update an order
{
		"adOrderNo"		: 15,
		"adminNo"		: 3,
		"restaurantNo"		: 4,
		"verificationDetail"	: "促銷廣告",
		"verified"		: true
}
```
<br>

 - Success Response: 200
 - Returns a 404 error if no order is found with the provided `adOrderNo`.
