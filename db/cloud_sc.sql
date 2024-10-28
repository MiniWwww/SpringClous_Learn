/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : cloud_sc

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 01/09/2023 19:29:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comments
-- ----------------------------
BEGIN;
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (1, 1, '这个产品真棒！', '张三23', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (2, 1, '好评！推荐购买！', '李四', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (3, 2, '非常满意的一次购物！', '王五', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (4, 3, '质量很好，发货速度快！', '赵六', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (5, 2, '物流有点慢，但产品不错！', '钱七', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (6, 4, '还没使用，期待效果！', '孙八', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (7, 4, '价格实惠，性价比高！', '周九', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (8, 3, '客服态度很好！', '吴十', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (9, 1, '很快就收到了，满意！', '郑十一', '2023-08-30');
INSERT INTO `comments` (`id`, `product_id`, `content`, `author`, `create_time`) VALUES (10, 2, '不错的购物体验！', '王十二', '2023-08-30');
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (1, 1, 2, 17998.00, '张三', 'zhangsan@example.com', '2023-08-28');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (2, 2, 11, 12999.00, '李四', 'lisi@example.com', '2023-08-29');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (3, 3, 3, 899723.00, '王五', 'wangwu@example.com', '2023-08-29');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (4, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (5, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (6, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (7, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (8, 12, 1, 199.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (9, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (10, 3, 1, 12999.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (11, 3, 1, 12999.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (12, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (13, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (14, 2, 1, 1299.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (15, 3, 1, 12999.00, 'admin', '2908111@qq.com', '2023-09-01');
INSERT INTO `orders` (`id`, `product_id`, `quantity`, `total_price`, `customer_name`, `customer_email`, `order_date`) VALUES (16, 3, 1, 12999.00, 'admin', '2908111@qq.com', '2023-09-01');
COMMIT;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `specifications` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `material` varchar(100) DEFAULT NULL,
  `is_available` int DEFAULT '0',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of products
-- ----------------------------
BEGIN;
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (1, 'iPhone 13 Pro', '全新的iPhone 13 Pro', '规格: 256GB', 8999.00, 1000, '材质: 铝合金玻璃', 0, '/src/assets/images/iPhone 13 Pro.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (2, 'AirPods Pro', '苹果AirPods Pro无线耳机', '规格: 蓝牙5.0', 1299.00, 200, '材质: 塑料', 0, '/src/assets/images/AirPods Pro.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (3, 'MacBook Pro M1', 'Apple MacBook Pro M1芯片', '规格: 16GB RAM, 512GB SSD', 12999.00, 50, '材质: 铝合金', 0, '/src/assets/images/macbookprom1.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (4, 'Samsung Galaxy S21', '三星Galaxy S21智能手机', '规格: 128GB 存储', 6999.00, 150, '材质: 玻璃', 0, '/src/assets/images/Samsung Galaxy S21.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (5, 'Sony Alpha A7III', '索尼Alpha A7III全画幅相机', '规格: 24.2MP', 13999.00, 80, '材质: 合金', 0, '/src/assets/images/Sony Alpha A7III.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (6, 'DJI Mavic Air 2', '大疆Mavic Air 2无人机', '规格: 4K 摄像头', 6999.00, 1001, '材质: 聚碳酸酯', 0, '/src/assets/images/DJI Mavic Air 2.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (7, 'Bose QuietComfort 35 II', 'Bose QuietComfort 35 II降噪耳机', '规格: 无线蓝牙', 1999.00, 120, '材质: 皮革', 0, '/src/assets/images/Bose QuietComfort 35 II.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (8, 'Nintendo Switch', '任天堂Switch游戏机', '规格: 32GB 存储', 2999.00, 180, '材质: 塑料', 0, '/src/assets/images/switch.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (9, 'GoPro HERO9 Black', 'GoPro HERO9 Black运动相机', '规格: 5K 视频', 3499.00, 90, '材质: 高强度塑料', 0, '/src/assets/images/gopro.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (11, 'Canon EOS R6', '佳能EOS R6全画幅相机', '规格: 20.1MP', 17999.00, 30, '材质: 镁合金', 0, '/src/assets/images/canno.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (12, 'Xiaomi Mi Band 6', '小米Mi Band 6智能手环', '规格: AMOLED 屏幕', 199.00, 500, '材质: TPU', 0, '/src/assets/images/Xiaomi Mi Band 6.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (13, 'LG OLED CX65', 'LG OLED CX65 电视', '规格: 65英寸 4K', 9999.00, 70, '材质: 无框金属', 0, '/src/assets/images/LG OLED CX65.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (14, 'Huawei FreeBuds 4i', '华为FreeBuds 4i真无线耳机', '规格: 主动降噪', 499.00, 300, '材质: 塑料', 0, '/src/assets/images/Huawei FreeBuds 4i.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (15, 'ASUS ROG Strix G15', '华硕ROG Strix G15 游戏笔记本', '规格: Intel i7, 16GB RAM, RTX 3070', 10999.00, 40, '材质: 铝合金', 0, '/src/assets/images/ASUS ROG Strix G15.png');
INSERT INTO `products` (`id`, `name`, `description`, `specifications`, `price`, `stock`, `material`, `is_available`, `img`) VALUES (16, 'Beats Solo Pro', 'Beats Solo Pro无线耳机', '规格: Apple H1芯片', 1699.00, 60, '材质: 塑料', 0, '/src/assets/images/Beats Solo Pro.png');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `email`) VALUES (1, '张三', 'password', '普通用户', 'zhangsan@example.com');
INSERT INTO `users` (`id`, `username`, `password`, `role`, `email`) VALUES (4, 'admin', '123456', '管理员', '2908111@qq.com');
INSERT INTO `users` (`id`, `username`, `password`, `role`, `email`) VALUES (5, 'admin12', 'admin', '普通用户', '234234');
INSERT INTO `users` (`id`, `username`, `password`, `role`, `email`) VALUES (7, 'abcd', '12345', '普通用户', '29081666@qq.com');
INSERT INTO `users` (`id`, `username`, `password`, `role`, `email`) VALUES (8, 'test', 'test', '普通用户', '17778@qq.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
