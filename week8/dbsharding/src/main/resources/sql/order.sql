create schema test_0;
create schema test_1;

CREATE TABLE IF NOT EXISTS test_0.order_0 (
  `id` bigint(8) NOT NULL,
  `user_id` bigint(8) NOT NULL,
  `code` varchar(255) NULL,
  `name` varchar(255) NULL,
  `total` decimal(10, 2) NOT NULL,
  `status` varchar(255) NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE test_0.order_0 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_1 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_1 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_2 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_2 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_3 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_3 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_4 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_4 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_5 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_5 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_6 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_6 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_7 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_7 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_8 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_8 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_9 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_9 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_10 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_10 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_11 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_11 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_12 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_12 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_13 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_13 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_14 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_14 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_0.order_15 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_0.order_15 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_0 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );
ALTER TABLE test_1.order_0 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_1 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_1 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_2 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_2 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_3 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_3 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_4 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_4 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_5 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_5 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_6 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_6 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_7 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_7 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_8 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_8 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_9 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_9 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_10 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_10 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_11 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_11 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_12 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_12 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_13 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_13 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_14 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_14 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS test_1.order_15 (
    `id` bigint(8) NOT NULL,
    `user_id` bigint(8) NOT NULL,
    `code` varchar(255) NULL,
    `name` varchar(255) NULL,
    `total` decimal(10, 2) NOT NULL,
    `status` varchar(255) NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NULL,
    PRIMARY KEY (`id`)
    );

ALTER TABLE test_1.order_15 ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);