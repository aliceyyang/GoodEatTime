// console.log($("div.product__rating .fill-ratings"));

// 修改商品星等
$("div.product__rating .fill-ratings").attr("style", "width: 70%")

/**
 * 抓全部產品、計算星等後放入
 * 資料格式如下
 * 
 * 12筆一頁分頁???
 * 
 * 依商品類別篩選
 * 
 * 加入購物車->跳轉至購物車頁面，修改資料庫中購物車的內容
 * 
 * 價格排序
 * 
 * 優惠券優先排序???
 * 
 * 關鍵字搜尋???
 * 
 * 漢堡&清單列表拿掉
 * 
 */
/* 資料格式
[
    {
       "prodNo":"商品編號",
       "prodName":"商品名稱",
       "restaurantName":"餐廳名稱",
       "prodCategory":"商品類別",
       "prodPrice":"商品價格",
       "averageRating":"平均評分"
    },
    {
       "prodNo":"商品編號",
       "prodName":"商品名稱",
       "restaurantName":"餐廳名稱",
       "prodCategory":"商品類別",
       "prodPrice":"商品價格",
       "averageRating":"平均評分"
    }
 ]
 */