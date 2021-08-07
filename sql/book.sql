
DROP DATABASE IF EXISTS book; ## 如果原来的数据库存在，就删除

CREATE DATABASE book;			## 创建数据库

USE book;					## 切换到数据库


##创建表t_user
CREATE TABLE t_user(
                       `id` INT PRIMARY KEY AUTO_INCREMENT,
                       `username` VARCHAR(50) NOT NULL UNIQUE,
                       `password` VARCHAR(32) NOT NULL,
                       `email` VARCHAR(50)
);

##插入初始数据
INSERT INTO t_user(username,`password`,email) VALUES('admin','admin','admin@qq.com');

# 创建book表
CREATE TABLE `t_book` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) DEFAULT NULL,
                          `price` decimal(11,2) DEFAULT NULL,
                          `author` varchar(100) DEFAULT NULL,
                          `sales` int DEFAULT NULL,
                          `stock` int DEFAULT NULL,
                          `img_path` varchar(200) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
# 插入初始数据
insert into t_book(`name`, `price`, `author`, `sales`, `stock`, `img_path`)
values ('Pytorch深度学习', 100, '印度', 676, 30, 'static/img/default.jpg');

# 创建订单表t_order
CREATE TABLE `t_order` (
                           `order_id` varchar(50) NOT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `price` decimal(11,2) DEFAULT NULL,
                           `status` int DEFAULT NULL,
                           `user_id` int DEFAULT NULL,
                           PRIMARY KEY (`order_id`),
                           KEY `user_id` (`user_id`),
                           CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

#插入初始数据
insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`)
values ('16226978501731', '2021-6-3 13:24:10', 100, 0, 1);

# 创建订单项表
CREATE TABLE `t_order_item` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `name` varchar(100) DEFAULT NULL,
                                `count` int DEFAULT NULL,
                                `price` decimal(11,2) DEFAULT NULL,
                                `total_price` decimal(11,2) DEFAULT NULL,
                                `order_id` varchar(50) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `order_id` (`order_id`),
                                CONSTRAINT `t_order_item_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
# 28	天天开心	1	68.00	68.00	16226978501731
insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`)
values ('Pytorch深度学习', 1, 100, 100, '16226978501731');




