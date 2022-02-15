CREATE TABLE `order`  (
  `id` bigint(8) NOT NULL,
  `code` varchar(255) NULL,
  `name` varchar(255) NULL,
  `total` decimal(10, 2) NOT NULL,
  `status` varchar(255) NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order_product`  (
  `id` int NOT NULL,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `product_num` int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product`  (
  `id` bigint(8) NOT NULL,
  `code` varchar(255) NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `desc` varchar(255) NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `table_1`  ();

CREATE TABLE `user`  (
  `id` bigint(8) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_order`  (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `order_product` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);
ALTER TABLE `order_product` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
ALTER TABLE `user_order` ADD CONSTRAINT `fk_user_order_user_order_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_order` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

