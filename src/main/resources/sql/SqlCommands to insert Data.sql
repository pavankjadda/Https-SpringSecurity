
/* Insert Data into User Table  */
INSERT INTO `springtesting`.`user`(`id`, `active`, `username`, `password`)
VALUES (1001, true, 'admin', '$2y$11$qZmN0TMkp2hv0s1f4sXpueLVK4a3j6Hb6SziQNBY0B6p0e7hY/IOy');
INSERT INTO `springtesting`.`user`(`id`, `active`, `username`, `password`)
VALUES (1002, true, 'user', '$2y$11$vk0Pune5m/r0.s/kaLfwX.03Eibgu1kFoFksmy9vLylw7Y527gGGS');




/* Insert Data into Category Table */
INSERT INTO `springtesting`.`category`(`id`, `name`)
VALUES (2002, 'Grocery');
INSERT INTO `springtesting`.`category`(`id`, `name`)
VALUES (2003, 'Electronics');
INSERT INTO `springtesting`.`category`(`id`, `name`)
VALUES (2001, 'Books');



/* Insert into Currency table */
INSERT INTO springtesting.currency
VALUES (10001, 'USD', 'United States Dollar', '$');

/* Insert Data into Price Table*/
INSERT INTO springtesting.price
values (5001, 349.99, 1);

/* Insert Data into Product Table  */
INSERT INTO `springtesting`.`product`(`id`, `name`, `category_id`)
VALUES (3001, 'iPhoneX', 1003);
INSERT INTO `springtesting`.`product`(`id`, `name`, `category_id`)
VALUES (3002, 'GalaxyS10', 1003);
INSERT INTO `springtesting`.`product`(`id`, `name`, `category_id`)
VALUES (3003, 'Google Pixel', 1003);



/* Insert Data into Order Detail Table  */
INSERT INTO `springtesting`.`order_detail`(`id`, `purchased_by`)
VALUES (4001, 1001);



/* Insert Data into Order Detail Products Table  */
INSERT INTO `springtesting`.`order_detail_products_list`(`order_detail_id`, `products_list_id`)
VALUES (4001, 3001);
INSERT INTO `springtesting`.`order_detail_products_list`(`order_detail_id`, `products_list_id`)
VALUES (4001, 3002);
INSERT INTO `springtesting`.`order_detail_products_list`(`order_detail_id`, `products_list_id`)
VALUES (4001, 3003);
