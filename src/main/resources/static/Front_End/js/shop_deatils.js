// console.log("read success");

// 商品星等調整
$("div.product__details__rating .fill-ratings").attr("style", "width: 70%")

/**
 * 使用者傳入的商品編號->controller->把prodInfoVO傳回此頁面
 * 部分資料需轉換restaurantNo -> restaurantName, prodCategoryNo -> prodCategory
 * 
 * 考慮新增商品簡單描述資料
 * 
 * 類似商品->隨機找同類別的產品顯示
 * 資料格式同商城
 * 
 * 加入購物車->跳轉至購物車頁面，修改資料庫中購物車的內容
 * 
 * 商品評論
 * 評論部分尚未呈現，可以參考首頁的評論部分
 * 先用prodOrderDetail表格的資料抓出來放到網頁中
 * 後續可以考慮再增加memberName, memberPic等資料呈現
 * 
 * 商品詳細改用longtext???
 * 
 */