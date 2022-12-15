drop table if exists restaurantCarouselPic;
drop table if exists menu;
drop table if exists restaurantPost;


--  restaurantCarouselPic
/*==========================================================================================*/
create table restaurantCarouselPic(
carouselPicNo int auto_increment not null primary key comment '輪播圖片編號',
restaurantNo int unsigned not null comment '餐廳編號',
carouselPic longblob comment '輪播圖片',
constraint FK_restaurantCarouselPic_restaurantNo foreign key(restaurantNo) references restaurant(restaurantNo));

insert into restaurantCarouselPic(restaurantNo,carouselPic)
values(1,null),
(2,null),
(2,null),
(3,null),
(4,null);
commit;

--  menu
/*==========================================================================================*/
create table menu(
menuNo int auto_increment not null primary key comment '菜單編號',
restaurantNo int unsigned not null comment '餐廳編號',
menuPic longblob comment '菜單圖片',
menuPicRemark varchar(200) comment '菜單圖片說明',
constraint FK_menu_restaurantNo foreign key(restaurantNo) references restaurant(restaurantNo));

insert into menu(restaurantNo,menuPic,menuPicRemark)
values(1,null,'餐廳編號一的第一個菜單圖片說明'),
(1,null,'餐廳編號一的第二個菜單圖片說明'),
(2,null,'餐廳編號二的第一個菜單圖片說明'),
(4,null,'餐廳編號四的第一個菜單圖片說明'),
(5,null,'餐廳編號五的第一個菜單圖片說明');
commit;

--  restaurantPost
/*==========================================================================================*/

create table restaurantPost(
restaurantPostNo int auto_increment not null primary key comment '貼文編號',
restaurantNo int unsigned not null comment '餐廳編號',
postType varchar(10) comment '貼文類型',
postPic longblob comment '貼文圖片',
postTitle varchar(50) not null comment '貼文標題',
postContent varchar(800) not null comment '貼文內容',
constraint FK_restaurantPost_restaurantNo foreign key(restaurantNo) references restaurant(restaurantNo));

insert into restaurantPost(restaurantNo,postType,postPic,postTitle,postContent)
values(1,'熱門活動',null,'餐廳編號一的貼文標題','即時獲取薄多義的第一手資訊，別錯過我們的最新優惠以及各式體驗活動，活動可能因地區與分店而有所不同'),
(2,'消息公告',null,'餐廳編號二的貼文標題','欣葉台菜創始店榮獲台北米其林指南2022,2021,2020,2019,2018入選餐廳'),
(3,'優惠券',null,'餐廳編號三的貼文標題','Bonus Star將於完成購買後之24小時內生效，顧客可自行登入星巴克網站或APP查詢'),
(3,'紅利點數',null,'餐廳編號三的貼文標題2','本活動之贈星回饋記錄均以本公司系統紀錄為準。會員若於活動後銷退重結，將無法再贈星');
commit;