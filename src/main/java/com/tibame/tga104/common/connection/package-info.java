/**
 * 這邊放一些共用的類別
 * 
 * ServiceLocator為黃彬華老師上JDBC時使用來產生DataSource的類別
 * HibernateUtil為馬全德老師上Hibernate時使用來產生SessionFactory的類別
 * 兩者皆為Singleton Design Pattern(單例模式)實作的經典範例
 * 但不用上面這2個類別來寫也是可以
 * 
 * ConnectionTest_JDBC & ConnectionTest_JNDI 這2個為用來測試連線的程式
 * 成功與資料庫連線的話會在Console印出以下結果
 * RestaurantVO [restaurantNo=1, restaurantTel=0229540410, restaurantName=薄多義, restaurantTaxIDNo=53914855, restaurantAccountInfo=null, restaurantBusinessHour=11:00-20:30, restaurantAddr=台北市中正區忠孝東路一段150號, restaurantStatus=false, restaurantAccount=restaurant1001, restaurantPassword=1001restaurant, restaurantCommentQuantity=0, totalCommentRating=0]
 * 
 */
/**
 * @author Ming
 */
package com.tibame.tga104.common.connection;