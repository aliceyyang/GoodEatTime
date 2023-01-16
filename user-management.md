# User Management

Good Eat Time has three different types of users, **member**, **restaurant** and platform **administrator**.

| Role | id | **Description** |
| :--- | :--- | :--- |
| administrator | `adminNo` | An administrative user. Administrators can manage system-wide settings as well as other user accounts like *member* and *restaurant*. |
| member | `memberNo` | A non-administrative user. Members can shop, reserve a table in Good Eat Time platform. |
| restaurant | `restaurantNo` | A non-administrative user. Restaurants can manage its own page and customer orders. They can also place advertisements on our website too. |

## Administrator
Administrators have the following format:
```JSON

{
	  "adminNo"		: 1,
	  "adminAccount"	: "res_A_11",
	  "adminPassword"	: "res1_P@ssOrd",
	  "adminName"		: "小吳",
	  "modifyAdminData"	: true,
	  "modifyMemberData"	: true,
	  "verifyRestaurant"	: true,
	  "verifyAdCoupon"	: true,
}
```



## Member
Members have the following format:
```JSON
{
	  "memberNo"			: 1,
	  "memberLevel"			: 3,
	  "name"			: "Chris",
	  "birthday"			: null,
	  "mail"			: "chris2000@gmail.com",
	  "memberPassword"		: null,
	  "verificationAccount"		: true,
	  "tel"				: "0912345678",
	  "point"			: 20,
	  "memberPic"			: null
}
```
<br>

| URL | method | **Description** |
| :--- | :--- | :--- |
| /admin/member-accounts | `Get` | get member list |
| /admin/member-accounts/{memberNo} | `Get` | get single member |
| /admin/member-accounts/{memberNo} | `PUT` | update a member|


```JSON 
// get all members
[
	{
	  "memberNo"			: 1,
	  "memberLevel"			: 3,
	  "name"			: "Chris",
	  "birthday"			: null,
	  "mail"			: "chris2000@gmail.com",
	  "memberPassword"		: null,
	  "verificationAccount"		: true,
	  "tel"				: "0912345678",
	  "point"			: 20,
	  "memberPic"			: null
	},
	{
	  "memberNo"			: 2,
	  "memberLevel"			: 2,
	  "name"			: "David",
	  "birthday"			: null,
	  "mail"			: "ddavid1980@gmail.com",
	  "memberPassword"		: null,
	  "verificationAccount"		: true,
	  "tel"				: "0983625174",
	  "point"			: 30,
	  "memberPic"			: null
	}
]	
```
```JSON
// update a member (request body)
{
	  "memberLevel"			:2,
	  "verificationAccount"		:true
}
```


## Restaurant
Restaurants have the following format:
```JSON
{
	  "restaurantNo"			: 1,
	  "restaurantTel"			: "0229540410",
	  "restaurantName"			: "薄多義",
	  "restaurantTaxIDNo"			: "53914855",
	  "restaurantAccountInfo"		: null,
	  "restaurantBusinessHour"		: "11:00-20:30",
	  "restaurantAddr"			: "台北市中正區忠孝東路一段150號",
	  "restaurantStatus"			: true,
	  "restaurantAccount"			: "restaurant1001@gmail.com",
	  "restaurantPassword"			: "1001restaurant",
	  "restaurantCommentQuantity"		: 0,
	  "totalCommentRating"			: 0
}
```
<br>

| URL | method | **Description** |
| :--- | :--- | :--- |
| /admin/restaurant-accounts | `Get` | get restaurant list |
| /admin/restaurant-accounts/{restaurantNo} | `Get` | get single restaurant |
| /admin/restaurant-accounts/{restaurantNo} | `PUT` | update a restaurant|

```JSON 
// get all members
[
	{
	  "restaurantNo"			: 1,
	  "restaurantTel"			: "0229540410",
	  "restaurantName"			: "薄多義",
	  "restaurantTaxIDNo"			: "53914855",
	  "restaurantAccountInfo"		: null,
	  "restaurantBusinessHour"		: "11:00-20:30",
	  "restaurantAddr"			: "台北市中正區忠孝東路一段150號",
	  "restaurantStatus"			: true,
	  "restaurantAccount"			: "restaurant1001@gmail.com",
	  "restaurantPassword"			: "1001restaurant",
	  "restaurantCommentQuantity"		: 0,
	  "totalCommentRating"			: 0
	},
	{
	  "restaurantNo"			: 2,
	  "restaurantTel"			: "0225963255",
	  "restaurantName"			: "欣葉台菜",
	  "restaurantTaxIDNo"			: "12107610",
	  "restaurantAccountInfo"		: null,
	  "restaurantBusinessHour"		: "11:00-20:30",
	  "restaurantAddr"			: "台北市中正區林森南路1號",
	  "restaurantStatus"			: true,
	  "restaurantAccount"			: "restaurant1002@gmail.com",
	  "restaurantPassword"			: "1002restaurant",
	  "restaurantCommentQuantity"		: 0,
	  "totalCommentRating"			: 0
	}
]	
```
```JSON
// update a member (request body)
{
	  "restaurantStatus"		:true
}
```
<br>

 - Success Response: 200
 - Returns a 404 error if no member/restaurant account is found with the provided ID.

