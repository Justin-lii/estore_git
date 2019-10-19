/*
drop sequence my_seq;
drop table es_line;
drop table es_order;
drop table es_address;
drop table es_customer;
drop table es_book;
drop table es_category;
*/
--以下命令在emd窗口执行
--切换到system用户，该用户名和密码根据自己修改
conn system/briup
--显示当前用户
show user
--创建新用户，赋予权限
create user estore identified by estore;
grant connect,resource to estore; 
conn estore/estore
show user
--注意修改连接数据库的用户名和密码，文件名为db.properties

--分类:es_category
create table es_category(
	id number(12) primary key,
	name varchar2(255) not null,
	description varchar2(255),
	category_id number(12) references es_category(id)
	);
--书籍表:es_book
create table es_book(
	id number(12) primary key,
	name varchar2(255) not null,
	price number(7,2) not null,
	author varchar2(100),
	publisher varchar2(100),
	pubDate date,
	description varchar2(255),
	category_id number(7) references es_category(id),
	images varchar2(100),
	click number
	);
--顾客表:es_customer
create table es_customer(
	id number(7) primary key,
	name varchar2(20) not null,
	password varchar2(20) not null,
	zipCode varchar2(10),
	telephone varchar2(20) not null,
	email varchar2(20)
	);
--收货地址:es_Address
create table es_address(
	id number(7) primary key, 
	receiveName varchar2(255) not null,
	address varchar2(255) not null,
	phone varchar2(15) not null,
	customer_id number(7) references es_customer(id)
	);
--订单表:es_orderForm
create table es_order(
	id number(12) primary key,
	cost number(9,2) not null,
	orderDate date not null,
	address_id number(7) references es_address(id),
	customer_id number(7) references es_customer(id)
	);
--订单项:es_orderLine
create table es_line(
	id number(12) primary key,
	num number(9) not null, 
	cost number(9,2) not null, 
	book_id number(12) references es_book(id),
	order_id number(12) references es_order(id)
);
--购物车：es_shopCar
create table es_shopCar(
	id number(12) primary key,
	total number,
	customer_id number references es_customer(id)
);
--购物车项：es_shopCarItem
create table es_shopCarItem(
	id number(12) primary key,
	num number(9),
	cost number,
	book_id number references es_book(id),
	shopCar_id number references es_shopCar(id)
);

--添加初始数据
--分类数据
insert into es_category(id,name,description) values(1,'文学','文学的描述');
insert into es_category(id,name,description) values(2,'社会科学','社会科学的描述');
insert into es_category(id,name,description) values(4,'小说','小说的描述');
insert into es_category(id,name,description) values(3,'计算机与互联网','计算机与互联网的描述');
insert into es_category(id,name,description) values(5,'传记','传记的描述');
insert into es_category(id,name,description) values(6,'历史','历史的描述');
insert into es_category(id,name,description) values(7,'医学','医学的描述');
insert into es_category values(8,'文学1类','文学1类的描述',1);
insert into es_category values(9,'文学2类','文学2类的描述',1);
insert into es_category values(10,'文学3类','文学3类的描述',1);
insert into es_category values(11,'社会科学1','社会科学1类的描述',2);
insert into es_category values(12,'社会科学2','社会科学2类的描述',2);
insert into es_category values(13,'社会科学3','社会科学3类的描述',2);
insert into es_category values(14,'小说1','小说1类的描述',3);
insert into es_category values(15,'小说2','小说2类的描述',3);
insert into es_category values(16,'小说3','小说3类的描述',3);
insert into es_category values(17,'计算机1','计算机1类的描述',4);
insert into es_category values(18,'计算机2','计算机2类的描述',4);
insert into es_category values(19,'计算机3','计算机3类的描述',4);
insert into es_category values(20,'传记1','传记1类的描述',5);
insert into es_category values(21,'传记2','传记2类的描述',5);
insert into es_category values(22,'传记3','传记3类的描述',5);
insert into es_category values(23,'历史类1','历史1类的描述',6);
insert into es_category values(24,'历史类2','历史2类的描述',6);
insert into es_category values(25,'历史类3','历史3类的描述',6);
insert into es_category values(26,'医学类1','医学类1的描述',7);
insert into es_category values(27,'医学类2','医学2类的描述',7);
insert into es_category values(28,'医学类3','医学3类的描述',7);
commit;
--图书数据
insert into es_book values(1,'文学类书1',20.0,'作者张三','出版社x','10-10月-07','文学1类',8,'images/p01.png',0);
insert into es_book values(2,'文学类书2',20.0,'作者张三','出版社x','10-10月-07','文学2类',9,'images/1.png',0);
insert into es_book values(3,'文学类书3',20.0,'作者张三','出版社x','10-10月-07','文学3类',10,'images/2.png',0);
insert into es_book values(4,'社会科学书1',20.0,'作者张三','出版社x','10-10月-07','社会科学1类',11,'images/p021.png',0);
insert into es_book values(5,'社会科学书2',20.0,'作者张三','出版社x','10-10月-07','社会科学2类',12,'images/2.png',0);
insert into es_book values(6,'社会科学书3',20.0,'作者张三','出版社x','10-10月-07','社会科学3类',13,'images/2.png',0);
insert into es_book values(7,'小说书1',20.0,'作者张三','出版社x','10-10月-07','小说1类',14,'images/2.png',0);
insert into es_book values(8,'小说书2',20.0,'作者张三','出版社x','07-10月-07','小说2类',15,'images/2.png',0);
insert into es_book values(9,'小说书3',20.0,'作者张三','出版社x','10-10月-07','小说3类',16,'images/2.png',0);
insert into es_book values(10,'计算机1书1',20.0,'作者张三','出版社x','10-10月-07','计算机1类',17,'images/2.png',0);
insert into es_book values(11,'计算机2书2',20.0,'作者张三','出版社x','09-10月-07','计算机2类',18,'images/2.png',0);
insert into es_book values(12,'计算机3书3',20.0,'作者张三','出版社x','10-10月-07','计算机3类',19,'images/2.png',0);
insert into es_book values(13,'传记书1',20.0,'作者张三','出版社x','10-10月-07','传记1类',20,'images/2.png',0);
insert into es_book values(14,'传记书2',20.0,'作者张三','出版社x','15-10月-07','传记2类',21,'images/2.png',0);
insert into es_book values(15,'传记书3',20.0,'作者张三','出版社x','10-10月-07','传记3类',22,'images/2.png',0);
insert into es_book values(16,'历史类书1',20.0,'作者张三','出版社x','17-10月-07','历史1类',23,'images/2.png',0);
insert into es_book values(17,'历史类书2',20.0,'作者张三','出版社x','22-10月-07','历史2类',24,'images/2.png',0);
insert into es_book values(18,'历史类书3',20.0,'作者张三','出版社x','10-10月-07','历史3类',25,'images/2.png',0);
insert into es_book values(19,'医学类书1',20.0,'作者张三','出版社x','10-10月-07','文学1类',26,'images/2.png',0);
insert into es_book values(20,'医学类书2',20.0,'作者张三','出版社x','10-10月-07','文学2类',27,'images/2.png',0);
insert into es_book values(21,'医学类书3',20.0,'作者张三','出版社x','10-10月-07','文学3类',28,'images/2.png',0);
commit;
--mybatis,insert插入需要用到序列
create sequence my_seq;

