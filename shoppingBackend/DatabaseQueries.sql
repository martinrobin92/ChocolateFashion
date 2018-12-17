CREATE TABLE onlineshopping.category    
(id int(10) auto_increment,    
 name varchar(50),    
 description varchar(50),
 imageURL varchar(50),
 active boolean,
 
 PRIMARY KEY (id )    
);   

INSERT INTO  onlineshopping.category VALUES(1,"laptop","intel family","heaven.png",1);
INSERT INTO onlineshopping.category VALUES(2,"mobile","iphone","rob.png",1);
INSERT INTO  onlineshopping.category VALUES(3,"headset","jbl","ron.png",1);
INSERT INTO  onlineshopping.category VALUES(4,"drone","xbox","max.png",1);


CREATE TABLE onlineshopping.user_details
(id INT(10),
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),

PRIMARY KEY (id)
);

INSERT INTO onlineshopping.user_details VALUES (1,"vivek","inba","admin",true,"admin","vivek@gmail.com","8867768198");
INSERT INTO onlineshopping.user_details VALUES (2,"rakesh","moorthy","supplier",true,"wasup","rakesh@gmail.com","8867768527");
INSERT INTO onlineshopping.user_details VALUES (3,"vimal","cedric","admin",true,"cedric","vimal@gmail.com","9738875113");
INSERT INTO onlineshopping.user_details VALUES (4,"allwyn","john","supplier",true,"ally7","ally@gmail.com","9686660879");

CREATE TABLE onlineshopping.product
(id INT(10),
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
active BOOLEAN,
category_id INT ,
supplier_id INT ,
purchases INT DEFAULT 0,
views INT DEFAULT 0,

PRIMARY KEY (id),
FOREIGN KEY (category_id) REFERENCES category(id),
FOREIGN KEY (supplier_id) REFERENCES user_details(id)
);


INSERT INTO onlineshopping.product VALUES (1,"xbdgdgd","iphone 5s","IPHONE","No 1 handset",45000,7,true,2,1,0,0);
INSERT INTO onlineshopping.product VALUES (2,"xbdgjkn","samsung galaxy","samsung","was No 1 handset",26000,2,true,2,4,0,0);
INSERT INTO onlineshopping.product VALUES (3,"xbertt","jbl","xbox","portable and wireless",12000,23,true,3,2,0,0);
INSERT INTO onlineshopping.product VALUES (4,"xbdgjkn","mac 5.0","Imacbook","No 1 laptop",150000,4,true,1,3,0,0);
