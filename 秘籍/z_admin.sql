/*
 Navicat Premium Dump SQL

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80046 (8.0.46)
 Source Host           : localhost:3306
 Source Schema         : z_admin

 Target Server Type    : MySQL
 Target Server Version : 80046 (8.0.46)
 File Encoding         : 65001

 Date: 06/06/2026 21:16:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods`  (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                               `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
                               `type` int NOT NULL DEFAULT 0 COMMENT '商品类型 1数码 2服装 3食品',
                               `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
                               `stock` int NOT NULL DEFAULT 0 COMMENT '库存',
                               `status` int NOT NULL DEFAULT 0 COMMENT '状态 0待审核 1上架  2下架',
                               `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
                               `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '品牌',
                               `free_shipping` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否包邮 0不包邮 1包邮',
                               `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                               `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
                               PRIMARY KEY (`id`) USING BTREE,
                               INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商城_商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_goods
-- ----------------------------
INSERT INTO `mall_goods` VALUES (1, 'Apple iPhone 15 Pro', 1, 7999.00, 120, 1, '全新A17 Pro芯片，钛金属边框，4800万像素主摄', 'Apple', 1, 1, '2025-03-01 10:00:00', 1, '2026-06-06 18:04:22', 0);
INSERT INTO `mall_goods` VALUES (2, '男士纯棉T恤', 2, 59.90, 500, 1, '100%纯棉，夏季透气圆领短袖', '优衣库', 1, 1, '2025-03-02 11:00:00', 1, '2025-03-10 09:20:00', 0);
INSERT INTO `mall_goods` VALUES (3, '三只松鼠坚果礼盒', 3, 128.00, 200, 1, '每日坚果混合果仁大礼包，健康零食', '三只松鼠', 0, 1, '2025-03-03 09:30:00', 1, '2025-03-12 16:45:00', 0);
INSERT INTO `mall_goods` VALUES (4, '华为Mate 60 Pro', 1, 6999.00, 80, 1, '卫星通话，鸿蒙系统，超可靠玄武架构', '华为', 0, 1, '2025-03-04 14:20:00', 1, '2025-03-18 11:10:00', 0);
INSERT INTO `mall_goods` VALUES (5, '女士针织开衫', 2, 189.00, 150, 2, '春秋季薄款慵懒风外套，柔软舒适', 'ZARA', 1, 1, '2025-03-05 08:45:00', 1, '2025-03-20 13:25:00', 0);
INSERT INTO `mall_goods` VALUES (6, '蒙牛纯牛奶整箱', 3, 49.90, 1000, 1, '250ml*16盒，全脂营养早餐奶', '蒙牛', 1, 1, '2025-03-06 12:10:00', 1, '2025-03-22 17:00:00', 0);
INSERT INTO `mall_goods` VALUES (7, '索尼WH-1000XM5耳机', 1, 1999.00, 45, 0, '旗舰降噪，AI智能降噪，30小时续航', 'Sony', 0, 1, '2025-03-07 15:30:00', 1, '2025-03-07 15:30:00', 0);
INSERT INTO `mall_goods` VALUES (8, '儿童运动鞋', 2, 99.00, 300, 1, '防滑耐磨，网面透气，男女童通用', '安踏儿童', 1, 1, '2025-03-08 10:00:00', 1, '2025-03-19 08:30:00', 0);
INSERT INTO `mall_goods` VALUES (9, '奥利奥饼干夹心', 3, 29.90, 800, 2, '原味巧克力味，扭一扭舔一舔泡一泡', '奥利奥', 0, 1, '2025-03-09 09:15:00', 1, '2025-03-21 14:50:00', 0);
INSERT INTO `mall_goods` VALUES (10, '小米电视EA55', 1, 1599.00, 60, 1, '55英寸金属全面屏，4K HDR，远场语音', '小米', 0, 1, '2025-03-10 13:40:00', 1, '2025-03-23 12:20:00', 0);
INSERT INTO `mall_goods` VALUES (11, '牛仔裤男直筒', 2, 149.00, 220, 1, '经典蓝色直筒，修身不紧绷', 'Levi\'s', 0, 1, '2025-03-11 11:25:00', 1, '2025-03-24 09:15:00', 0);
INSERT INTO `mall_goods` VALUES (12, '康师傅红烧牛肉面', 3, 4.50, 2000, 1, '方便面经典口味，面饼+酱包', '康师傅', 1, 1, '2025-03-12 07:50:00', 1, '2025-03-25 18:30:00', 0);
INSERT INTO `mall_goods` VALUES (13, '联想拯救者Y9000P', 1, 8999.00, 30, 0, '13代i9+RTX4060，2.5K高刷电竞屏', 'Lenovo', 0, 1, '2025-03-13 16:20:00', 1, '2025-03-13 16:20:00', 0);
INSERT INTO `mall_goods` VALUES (14, '雪纺连衣裙夏', 2, 239.00, 90, 1, '碎花雪纺，收腰显瘦，度假风', '茵曼', 1, 1, '2025-03-14 10:55:00', 1, '2025-03-26 10:40:00', 0);
INSERT INTO `mall_goods` VALUES (15, '海底捞自热火锅', 3, 39.00, 350, 2, '麻辣嫩牛，懒人自热方便火锅', '海底捞', 0, 1, '2025-03-15 12:35:00', 1, '2025-03-27 15:10:00', 0);
INSERT INTO `mall_goods` VALUES (16, '罗技G304无线鼠标', 1, 199.00, 180, 1, 'LIGHTSPEED无线，12000DPI，游戏办公', 'Logitech', 1, 1, '2025-03-16 14:05:00', 1, '2025-03-28 11:25:00', 0);
INSERT INTO `mall_goods` VALUES (17, '情侣睡衣套装', 2, 129.00, 110, 1, '纯棉柔软，夏季短袖家居服', '南极人', 1, 1, '2025-03-17 09:40:00', 1, '2025-03-29 16:50:00', 0);
INSERT INTO `mall_goods` VALUES (18, '卫龙辣条大礼包', 3, 19.90, 1500, 1, '魔芋爽+大面筋，麻辣零食组合', '卫龙', 0, 1, '2025-03-18 17:15:00', 1, '2025-03-30 08:20:00', 0);
INSERT INTO `mall_goods` VALUES (19, '戴尔XPS 13', 1, 11999.00, 15, 0, '超窄边框，轻薄商务笔记本，3.5K OLED', 'Dell', 0, 1, '2025-03-19 08:00:00', 1, '2025-03-19 08:00:00', 0);
INSERT INTO `mall_goods` VALUES (20, '男士商务衬衫', 2, 199.00, 130, 1, '免烫抗皱，纯棉长袖，职场必备', '海澜之家', 0, 1, '2025-03-20 11:10:00', 1, '2025-03-31 13:35:00', 0);
INSERT INTO `mall_goods` VALUES (21, '金龙鱼大米10kg', 3, 68.00, 400, 1, '东北大米，珍珠米，晶莹饱满', '金龙鱼', 1, 1, '2025-03-21 13:30:00', 1, '2025-04-01 09:55:00', 0);
INSERT INTO `mall_goods` VALUES (22, 'iPad Air 5', 1, 4799.00, 55, 1, 'M1芯片，10.9英寸全面屏，支持二代笔', 'Apple', 0, 1, '2025-03-22 15:45:00', 1, '2025-04-02 14:15:00', 0);
INSERT INTO `mall_goods` VALUES (23, '羊毛围巾冬季', 2, 89.00, 260, 2, '纯羊毛，保暖百搭，男女通用', '恒源祥', 1, 1, '2025-03-23 10:20:00', 1, '2025-04-03 12:05:00', 0);
INSERT INTO `mall_goods` VALUES (24, '农夫山泉饮用水', 3, 1.50, 5000, 1, '550ml*24瓶，天然弱碱性水', '农夫山泉', 1, 1, '2025-03-24 09:00:00', 1, '2025-04-04 18:45:00', 0);
INSERT INTO `mall_goods` VALUES (25, '大疆Mini 4 Pro无人机', 1, 4788.00, 20, 1, '轻于249g，全向避障，4K HDR', 'DJI', 0, 1, '2025-03-25 14:50:00', 1, '2025-04-05 10:30:00', 0);
INSERT INTO `mall_goods` VALUES (26, '老爹鞋女增高', 2, 168.00, 95, 1, '厚底显瘦，透气网面，百搭复古', '斐乐', 1, 1, '2025-03-26 12:15:00', 1, '2025-04-06 15:00:00', 0);
INSERT INTO `mall_goods` VALUES (27, '良品铺子零食大礼包', 3, 99.00, 280, 2, '巨型抱抱，30包混合零食', '良品铺子', 0, 1, '2025-03-27 11:40:00', 1, '2025-04-07 11:20:00', 0);
INSERT INTO `mall_goods` VALUES (28, '英特尔i7-13700K', 1, 3299.00, 25, 0, '16核24线程，台式机CPU，不带核显', 'Intel', 0, 1, '2025-03-28 16:10:00', 1, '2025-03-28 16:10:00', 0);
INSERT INTO `mall_goods` VALUES (29, '运动休闲裤男', 2, 79.00, 400, 1, '束脚针织裤，日常运动两穿', '李宁', 1, 1, '2025-03-29 08:35:00', 1, '2025-04-08 13:50:00', 0);
INSERT INTO `mall_goods` VALUES (30, '百草味每日坚果', 3, 59.90, 320, 1, '混合果仁+果干，每日一包', '百草味', 0, 1, '2025-03-30 10:05:00', 1, '2025-04-09 17:25:00', 0);
INSERT INTO `mall_goods` VALUES (31, '华硕RTX4060显卡', 1, 2699.00, 18, 1, 'DUAL系列，8GB显存，DLSS3', 'ASUS', 0, 1, '2025-03-31 13:20:00', 1, '2025-04-10 09:40:00', 0);
INSERT INTO `mall_goods` VALUES (32, '短袖POLO衫男', 2, 109.00, 210, 1, '珠地棉，商务休闲，多色可选', '七匹狼', 1, 1, '2025-04-01 09:55:00', 1, '2025-04-11 14:10:00', 0);
INSERT INTO `mall_goods` VALUES (33, '伊利安慕希酸奶', 3, 55.00, 600, 1, '希腊风味，蛋白含量高，205g*12盒', '伊利', 0, 1, '2025-04-02 11:30:00', 1, '2025-04-12 16:35:00', 0);
INSERT INTO `mall_goods` VALUES (34, '小米手环8', 1, 239.00, 320, 0, '1.62英寸AMOLED，血氧心率监测', '小米', 1, 1, '2025-04-03 14:45:00', 1, '2025-04-03 14:45:00', 0);
INSERT INTO `mall_goods` VALUES (35, '休闲帆布鞋女', 2, 69.00, 350, 1, '低帮帆布，糖果色，青春校园', '回力', 1, 1, '2025-04-04 10:15:00', 1, '2025-04-13 12:00:00', 0);
INSERT INTO `mall_goods` VALUES (36, '王小卤虎皮凤爪', 3, 29.90, 720, 2, '卤香鸡爪，火锅味/香辣味', '王小卤', 0, 1, '2025-04-05 12:50:00', 1, '2025-04-14 10:45:00', 0);
INSERT INTO `mall_goods` VALUES (37, 'Apple Watch Series 9', 1, 2999.00, 40, 1, '全天候视网膜屏，手势交互，S9芯片', 'Apple', 0, 1, '2025-04-06 15:20:00', 1, '2025-04-15 13:20:00', 0);
INSERT INTO `mall_goods` VALUES (38, '羽绒服女中长款', 2, 499.00, 45, 1, '90%白鸭绒，加厚保暖，冬季新款', '波司登', 0, 1, '2025-04-07 08:40:00', 1, '2025-04-16 11:55:00', 0);
INSERT INTO `mall_goods` VALUES (39, '可口可乐碳酸饮料', 3, 3.00, 3000, 1, '330ml易拉罐，冰爽口感', '可口可乐', 1, 1, '2025-04-08 09:25:00', 1, '2025-04-17 15:30:00', 0);
INSERT INTO `mall_goods` VALUES (40, '希捷2TB移动硬盘', 1, 569.00, 85, 1, 'USB3.0，便携存储，兼容多系统', 'Seagate', 1, 1, '2025-04-09 11:10:00', 1, '2025-04-18 14:05:00', 0);
INSERT INTO `mall_goods` VALUES (41, '加厚卫衣女', 2, 139.00, 170, 2, '加绒连帽，宽松慵懒，秋冬款', '美特斯邦威', 0, 1, '2025-04-10 13:45:00', 1, '2025-04-19 09:50:00', 0);
INSERT INTO `mall_goods` VALUES (42, '周黑鸭卤味组合', 3, 49.90, 250, 1, '鸭脖+鸭翅+锁骨，甜辣卤味', '周黑鸭', 0, 1, '2025-04-11 16:30:00', 1, '2025-04-20 18:15:00', 0);
INSERT INTO `mall_goods` VALUES (43, '飞利浦电动牙刷', 1, 399.00, 110, 1, '声波震动，清洁亮白，智能计时', 'Philips', 1, 1, '2025-04-12 10:00:00', 1, '2025-04-21 12:40:00', 0);
INSERT INTO `mall_goods` VALUES (44, '瑜伽裤女紧身', 2, 89.00, 230, 1, '高腰提臀，弹性大，运动健身', 'Lululemon', 1, 1, '2025-04-13 14:20:00', 1, '2025-04-22 10:25:00', 0);
INSERT INTO `mall_goods` VALUES (45, '德芙巧克力礼盒', 3, 79.00, 190, 0, '浓醇丝滑，心形礼盒装，表白礼物', '德芙', 0, 1, '2025-04-14 09:15:00', 1, '2025-04-14 09:15:00', 0);
INSERT INTO `mall_goods` VALUES (46, 'Redmi Note 13 Pro', 1, 1599.00, 210, 1, '2亿像素，120W快充，1.5K曲面屏', '红米', 0, 1, '2025-04-15 11:35:00', 1, '2025-04-23 15:45:00', 0);
INSERT INTO `mall_goods` VALUES (47, '棒球帽男女通用', 2, 39.00, 520, 1, '纯棉透气，可调节大小，刺绣logo', 'MLB', 1, 1, '2025-04-16 13:55:00', 1, '2025-04-24 14:10:00', 0);
INSERT INTO `mall_goods` VALUES (48, '洽洽瓜子大包装', 3, 12.90, 1300, 2, '焦糖味/山核桃味，五香味，休闲零食', '洽洽', 0, 1, '2025-04-17 15:40:00', 1, '2025-04-25 11:30:00', 0);
INSERT INTO `mall_goods` VALUES (49, '任天堂Switch游戏机', 1, 1899.00, 32, 1, '续航加强版，红蓝手柄，家庭娱乐', 'Nintendo', 0, 1, '2025-04-18 08:30:00', 1, '2025-04-26 09:55:00', 0);
INSERT INTO `mall_goods` VALUES (50, '西服套装男士', 2, 899.00, 28, 0, '修身两件套，商务正装，羊毛混纺', '雅戈尔', 0, 1, '2025-04-19 10:45:00', 1, '2025-04-19 10:45:00', 0);
INSERT INTO `mall_goods` VALUES (51, '光明新鲜牧场牛奶', 3, 22.90, 450, 1, '鲜牛乳，冷藏保存，营养丰富', '光明', 1, 1, '2025-04-20 12:10:00', 1, '2025-04-27 16:20:00', 0);
INSERT INTO `mall_goods` VALUES (52, '机械师键盘K500', 1, 299.00, 75, 1, '机械轴，RGB背光，电竞键盘', 'MACHENIKE', 0, 1, '2025-04-21 14:35:00', 1, '2025-04-28 13:15:00', 0);
INSERT INTO `mall_goods` VALUES (53, '真丝睡衣女夏', 2, 259.00, 60, 1, '桑蚕丝，清凉顺滑，短袖两件套', '曼妮芬', 1, 1, '2025-04-22 09:50:00', 1, '2025-04-29 10:40:00', 0);
INSERT INTO `mall_goods` VALUES (54, '王饱饱麦片', 3, 39.90, 380, 2, '非膨化，草莓优脆乳，代餐早餐', '王饱饱', 0, 1, '2025-04-23 11:25:00', 1, '2025-04-30 14:55:00', 0);
INSERT INTO `mall_goods` VALUES (55, '荣耀Magic6 Pro', 1, 5699.00, 38, 1, '卫星通信，单反级鹰眼相机，巨犀玻璃', 'Honor', 0, 1, '2025-04-24 15:10:00', 1, '2025-05-01 12:30:00', 0);
INSERT INTO `mall_goods` VALUES (56, '连帽卫衣男潮', 2, 119.00, 195, 1, 'oversize，印花设计，街头潮流', 'Champion', 0, 1, '2025-04-25 08:15:00', 1, '2025-05-02 09:05:00', 0);
INSERT INTO `mall_goods` VALUES (57, '好丽友派巧克力', 3, 22.50, 620, 1, '巧克力涂层+棉花糖夹心，6枚装', '好丽友', 1, 1, '2025-04-26 10:30:00', 1, '2025-05-03 16:45:00', 0);
INSERT INTO `mall_goods` VALUES (58, '绿联NAS私有云', 1, 1299.00, 22, 0, '双盘位，个人云存储，远程访问', '绿联', 0, 1, '2025-04-27 13:45:00', 1, '2025-04-27 13:45:00', 0);
INSERT INTO `mall_goods` VALUES (59, '马丁靴男英伦', 2, 289.00, 85, 1, '厚底增高，耐磨橡胶，经典8孔', 'Dr.Martens', 0, 1, '2025-04-28 09:20:00', 1, '2025-05-04 11:20:00', 0);
INSERT INTO `mall_goods` VALUES (60, '徐福记酥糖', 3, 15.90, 1100, 1, '传统酥糖，芝麻花生口味，散装500g', '徐福记', 1, 1, '2025-04-29 11:55:00', 1, '2025-05-05 13:50:00', 0);
INSERT INTO `mall_goods` VALUES (61, '三星990 PRO SSD', 1, 999.00, 48, 1, 'NVMe PCIe4.0，读取7450MB/s', 'Samsung', 0, 1, '2025-04-30 14:25:00', 1, '2025-05-06 10:35:00', 0);
INSERT INTO `mall_goods` VALUES (62, '骑行服套装男', 2, 399.00, 33, 2, '专业公路骑行服，透气速干，紧身', '捷酷', 0, 1, '2025-05-01 16:10:00', 1, '2025-05-07 15:10:00', 0);
INSERT INTO `mall_goods` VALUES (63, '雀巢速溶咖啡', 3, 45.00, 280, 1, '金牌黑咖啡，微研磨，100g罐装', 'Nestle', 1, 1, '2025-05-02 08:40:00', 1, '2025-05-08 09:25:00', 0);
INSERT INTO `mall_goods` VALUES (64, '极米Z7X投影仪', 1, 2999.00, 17, 1, '轻薄投影，1080P，哈曼卡顿音响', 'XGIMI', 0, 1, '2025-05-03 10:05:00', 1, '2025-05-09 12:55:00', 0);
INSERT INTO `mall_goods` VALUES (65, '针织帽冬季保暖', 2, 29.00, 430, 1, '毛线帽，加厚护耳，男女同款', '北极绒', 1, 1, '2025-05-04 12:30:00', 1, '2025-05-10 14:40:00', 0);
INSERT INTO `mall_goods` VALUES (66, '费列罗榛果巧克力', 3, 89.00, 145, 0, '金色包装，3粒*16条，婚庆喜糖', 'Ferrero', 0, 1, '2025-05-05 14:55:00', 1, '2025-05-05 14:55:00', 0);
INSERT INTO `mall_goods` VALUES (67, '漫步者R101V音箱', 1, 199.00, 96, 1, '2.1声道，木质低音箱，电脑音响', 'Edifier', 1, 1, '2025-05-06 09:15:00', 1, '2025-05-11 11:15:00', 0);
INSERT INTO `mall_goods` VALUES (68, '冲锋衣男女三合一', 2, 459.00, 40, 1, '防风防水，可拆卸内胆，户外登山', '探路者', 0, 1, '2025-05-07 11:40:00', 1, '2025-05-12 16:30:00', 0);
INSERT INTO `mall_goods` VALUES (69, '李子柒柳州螺蛳粉', 3, 13.90, 880, 2, '酸辣鲜爽，米粉+配料齐全', '李子柒', 0, 1, '2025-05-08 13:20:00', 1, '2025-05-13 10:05:00', 0);
INSERT INTO `mall_goods` VALUES (70, 'TPLINK路由器AX5400', 1, 399.00, 64, 1, 'WiFi6，双频，千兆端口，电竞加速', 'TP-LINK', 1, 1, '2025-05-09 15:45:00', 1, '2025-05-14 13:45:00', 0);
INSERT INTO `mall_goods` VALUES (71, '阔腿裤女夏薄', 2, 79.00, 310, 1, '雪纺宽松，高腰垂感，显瘦百搭', 'UR', 1, 1, '2025-05-10 08:55:00', 1, '2025-05-15 09:20:00', 0);
INSERT INTO `mall_goods` VALUES (72, '元气森林气泡水', 3, 5.00, 1800, 1, '0糖0脂0卡，白桃味/葡萄味', '元气森林', 0, 1, '2025-05-11 10:30:00', 1, '2025-05-16 15:55:00', 0);
INSERT INTO `mall_goods` VALUES (73, 'AMD Ryzen 7800X3D', 1, 2799.00, 19, 0, '8核16线程，3D V-Cache，游戏神U', 'AMD', 0, 1, '2025-05-12 12:15:00', 1, '2025-05-12 12:15:00', 0);
INSERT INTO `mall_goods` VALUES (74, '背带裤女牛仔', 2, 159.00, 56, 1, '复古蓝，破洞设计，可爱减龄', 'ONLY', 1, 1, '2025-05-13 14:40:00', 1, '2025-05-17 11:10:00', 0);
INSERT INTO `mall_goods` VALUES (75, '安佳全脂奶粉', 3, 49.00, 340, 1, '新西兰进口，高钙，1kg袋装', '安佳', 0, 1, '2025-05-14 16:25:00', 1, '2025-05-18 14:25:00', 0);
INSERT INTO `mall_goods` VALUES (76, '小米AX6000路由器', 1, 499.00, 53, 1, 'WiFi6增强版，6000M速率，Mesh组网', '小米', 1, 1, '2025-05-15 09:10:00', 1, '2025-05-19 10:50:00', 0);
INSERT INTO `mall_goods` VALUES (77, '短裤男运动', 2, 59.00, 280, 2, '速干面料，宽松五分，跑步健身', '迪卡侬', 1, 1, '2025-05-16 11:35:00', 1, '2025-05-20 12:35:00', 0);
INSERT INTO `mall_goods` VALUES (78, '旺旺大礼包', 3, 35.00, 490, 1, '雪饼+仙贝+浪味仙，童年回忆', '旺旺', 0, 1, '2025-05-17 13:55:00', 1, '2025-05-21 15:15:00', 0);
INSERT INTO `mall_goods` VALUES (79, '海康威视监控摄像头', 1, 299.00, 88, 1, '400万像素，红外夜视，双向语音', 'Hikvision', 0, 1, '2025-05-18 15:30:00', 1, '2025-05-22 09:40:00', 0);
INSERT INTO `mall_goods` VALUES (80, '小白鞋女板鞋', 2, 69.00, 370, 1, '贝壳头，真皮材质，百搭小白鞋', '阿迪达斯', 1, 1, '2025-05-19 08:45:00', 1, '2025-05-23 11:55:00', 0);
INSERT INTO `mall_goods` VALUES (81, '自嗨锅煲仔饭', 3, 25.00, 520, 0, '自热米饭，川味腊肠/菌菇牛肉', '自嗨锅', 0, 1, '2025-05-20 10:20:00', 1, '2025-05-20 10:20:00', 0);
INSERT INTO `mall_goods` VALUES (82, '罗技K380蓝牙键盘', 1, 169.00, 105, 1, '多设备切换，轻薄便携，三号电池', 'Logitech', 1, 1, '2025-05-21 12:45:00', 1, '2025-05-24 14:10:00', 0);
INSERT INTO `mall_goods` VALUES (83, '汉服女齐胸襦裙', 2, 329.00, 24, 1, '绣花大袖衫，唐朝风格，演出服', '重回汉唐', 0, 1, '2025-05-22 14:10:00', 1, '2025-05-25 16:35:00', 0);
INSERT INTO `mall_goods` VALUES (84, '统一老坛酸菜面', 3, 4.00, 2600, 2, '酸菜风味，面饼+酸菜酱料', '统一', 1, 1, '2025-05-23 16:35:00', 1, '2025-05-26 09:50:00', 0);
INSERT INTO `mall_goods` VALUES (85, '小米13 Ultra', 1, 5999.00, 31, 1, '徕卡光学全焦段四摄，2K专业屏', '小米', 0, 1, '2025-05-24 09:25:00', 1, '2025-05-27 12:30:00', 0);
INSERT INTO `mall_goods` VALUES (86, '五分裤男休闲', 2, 49.00, 450, 1, '工装风，多口袋，纯棉夏季短裤', '森马', 1, 1, '2025-05-25 11:15:00', 1, '2025-05-28 10:15:00', 0);
INSERT INTO `mall_goods` VALUES (87, '江小白果味酒', 3, 19.90, 680, 1, '蜜桃味/白葡萄味，低度果酒', '江小白', 0, 1, '2025-05-26 13:30:00', 1, '2025-05-29 14:45:00', 0);
INSERT INTO `mall_goods` VALUES (88, '雷蛇毒蝰迷你鼠标', 1, 199.00, 72, 0, '轻量化约61g，光学微动，电竞RGB', 'Razer', 0, 1, '2025-05-27 15:55:00', 1, '2025-05-27 15:55:00', 0);
INSERT INTO `mall_goods` VALUES (89, '老爹凉鞋女', 2, 89.00, 160, 1, '厚底松糕，魔术贴，夏季透气', '热风', 1, 1, '2025-05-28 08:20:00', 1, '2025-05-30 11:20:00', 0);
INSERT INTO `mall_goods` VALUES (90, '莫小仙自热米饭', 3, 15.00, 590, 1, '免煮，红烧肉/黄焖鸡口味', '莫小仙', 0, 1, '2025-05-29 10:45:00', 1, '2025-05-31 13:55:00', 0);
INSERT INTO `mall_goods` VALUES (91, 'ThinkPad X1 Carbon', 1, 13999.00, 12, 1, '碳纤维机身，2.8K OLED，轻薄商务', 'Lenovo', 0, 1, '2025-05-30 13:10:00', 1, '2025-06-01 15:30:00', 0);
INSERT INTO `mall_goods` VALUES (92, '太阳镜男偏光', 2, 99.00, 210, 2, '方形镜框，UV400保护，驾驶必备', '暴龙', 0, 1, '2025-05-31 15:35:00', 1, '2025-06-02 09:10:00', 0);
INSERT INTO `mall_goods` VALUES (93, '红牛维生素饮料', 3, 6.50, 1200, 1, '250ml金罐，提神抗疲劳', '红牛', 1, 1, '2025-06-01 09:50:00', 1, '2025-06-03 11:45:00', 0);
INSERT INTO `mall_goods` VALUES (94, '华硕TUF B760主板', 1, 999.00, 27, 1, 'DDR5，PCIe 5.0，供电散热装甲', 'ASUS', 0, 1, '2025-06-02 11:25:00', 1, '2025-06-04 14:20:00', 0);
INSERT INTO `mall_goods` VALUES (95, '帆布包斜挎女', 2, 39.00, 500, 1, '印花布袋，文艺简约，容量大', '无印良品', 1, 1, '2025-06-03 13:55:00', 1, '2025-06-05 10:55:00', 0);
INSERT INTO `mall_goods` VALUES (96, '咪咪虾条零食', 3, 1.00, 8000, 1, '童年回忆，虾味条，小包装', '咪咪', 1, 1, '2025-06-04 16:20:00', 1, '2025-06-06 13:30:00', 0);
INSERT INTO `mall_goods` VALUES (97, '一加12手机', 1, 5299.00, 41, 0, '哈苏影像，2K东方屏，骁龙8Gen3', 'OnePlus', 0, 1, '2025-06-05 08:35:00', 1, '2025-06-05 08:35:00', 0);
INSERT INTO `mall_goods` VALUES (98, '速干T恤男运动', 2, 49.00, 380, 1, '吸湿排汗，无痕设计，健身跑步', '安德玛', 1, 1, '2025-06-06 10:00:00', 1, '2025-06-07 15:25:00', 0);
INSERT INTO `mall_goods` VALUES (99, '美心流心奶黄月饼', 3, 328.00, 55, 1, '香港美心，中秋礼盒，流心馅料', '美心', 0, 1, '2025-06-07 12:15:00', 1, '2025-06-08 09:40:00', 0);
INSERT INTO `mall_goods` VALUES (100, 'Garmin Forerunner 255', 1, 2880.00, 23, 1, '专业跑步手表，GPS，心率血氧', 'Garmin', 0, 1, '2025-06-08 14:30:00', 1, '2025-06-09 16:55:00', 0);

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'POST' COMMENT '请求方法',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '操作路由',
  `type` int NOT NULL DEFAULT 1 COMMENT '0超管权限 1页面权限 2操作权限',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '权限父节点id',
  `access_level` int NOT NULL DEFAULT 0 COMMENT '权限等级 1允许匿名访问  2登录即可访问  3须有此权限可访问',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_method_path`(`method` ASC, `path` ASC) USING BTREE,
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 100004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统_权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES (-1, '', '*', -1, -1, 0, '超管权限', '超管权限', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (1, 'POST', '/auth/login', 2, 0, 1, '登录', '登录', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (2, 'POST', '/auth/logout', 2, 0, 2, '登出', '登出', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (3, 'GET', '/auth/info', 2, 0, 2, '登录信息', '登录信息', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (100, '', '/system', 1, 0, 3, '系统设置', '系统设置', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (101, '', '/system/user', 1, 100, 3, '用户管理', '用户管理', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (102, 'POST', '/system/user/list', 2, 101, 3, '用户列表', '用户列表', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (103, 'POST', '/system/user/add', 2, 102, 3, '新增用户', '新增用户', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (104, 'GET', '/system/user/{id}', 2, 102, 3, '用户详情', '用户详情', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (105, 'PUT', '/system/user', 2, 102, 3, '修改用户信息', '修改用户信息', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (106, 'PUT', '/system/user/password', 2, 102, 3, '修改用户密码', '修改用户密码', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (107, 'DELETE', '/system/user/{id}', 2, 102, 3, '删除用户', '删除用户', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (108, 'POST', '/system/user/permission', 2, 202, 3, '修改用户权限', '修改用户权限', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (109, 'PUT', '/system/user/role', 2, 102, 3, '修改角色权限', '修改角色权限', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (151, '', '/system/role', 1, 100, 3, '角色管理', '角色管理', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (152, 'POST', '/system/role/list', 2, 151, 3, '角色列表', '角色列表', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (153, 'PUT', '/system/role/permission', 2, 201, 3, '修改角色权限', '修改角色权限', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (154, 'POST', '/system/role/add', 2, 152, 3, '新增角色', '新增角色', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (155, 'DELETE', '/system/role/{id}', 2, 152, 3, '删除角色', '删除角色', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (156, 'GET', '/system/role/all', 2, 0, 2, '全部角色', '全部角色', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (201, 'GET', '/system/permission/role/tree', 2, 152, 3, '根据角色查询权限树结构', '根据角色查询权限树结构', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (202, 'GET', '/system/permission/user/tree', 2, 152, 3, '根据用户查询权限树结构', '根据用户查询权限树结构', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (500, '', '/mall', 1, 0, 3, '商城管理', '商城管理', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (501, '', '/mall/goods', 1, 500, 3, '商品管理', '商品管理', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (502, 'POST', '/mall/goods/list', 2, 501, 3, '商品列表', '商品列表', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (503, 'GET', '/mall/goods/{id}', 2, 502, 3, '商品详情', '商品详情', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (504, 'PUT', '/mall/goods', 2, 502, 3, '更改商品信息', '更改商品信息', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_permission` VALUES (505, 'POST', '/mall/goods/export', 2, 502, 3, '导出商品信息', '导出商品信息', 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` int NOT NULL DEFAULT 0 COMMENT '角色类型 0 普通角色 1超管',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type`(`type` ASC) USING BTREE COMMENT '角色类型',
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统_角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES (1, '超级管理员', 1, '', 0, '2023-11-30 10:33:15', 0, '2023-11-30 10:33:15', 0);
INSERT INTO `system_role` VALUES (2, '权限测试', 0, '', 0, '2026-05-29 22:52:27', 0, '2026-05-29 22:52:27', 0);
INSERT INTO `system_role` VALUES (3, '普通用户', 0, '', 0, '2026-06-02 13:05:20', 0, '2026-06-02 13:05:20', 0);

-- ----------------------------
-- Table structure for system_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_role_permission`;
CREATE TABLE `system_role_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_id` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  `permission_id` bigint NOT NULL DEFAULT 0 COMMENT '权限id',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_roleId`(`role_id` ASC) USING BTREE COMMENT '角色id',
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统_角色权限关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_role_permission
-- ----------------------------
INSERT INTO `system_role_permission` VALUES (1, 1, -1, 0, '2024-09-10 15:02:18', 0, '2024-09-10 15:02:18', 0);
INSERT INTO `system_role_permission` VALUES (2, 2, 100, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (3, 2, 101, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (4, 2, 102, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (5, 2, 103, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (6, 2, 104, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (7, 2, 105, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (8, 2, 201, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (9, 2, 106, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (10, 2, 202, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (11, 2, 107, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (12, 2, 108, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (13, 2, 109, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (14, 2, 151, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (15, 2, 152, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (16, 2, 153, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (17, 2, 154, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);
INSERT INTO `system_role_permission` VALUES (18, 2, 155, 1, '2026-06-06 10:44:41', 1, '2026-06-06 10:44:41', 0);

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `mobile` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `type` int NOT NULL DEFAULT 0 COMMENT '用户类型 0普通用户 1超管',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `disabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否禁用',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type`(`type` ASC) USING BTREE COMMENT '用户类型',
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统_用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1, '13111111111', '123@qq.com', 'admin', '$2a$10$fO/0pSZM.IXlWHmn.BsiEuqlRKz4vHikROeVucYBesdIdzMcqwBhO', '超管', 1, 1111, '2022-12-22 15:27:23', 0, '2026-05-31 12:58:41', 0, 0);
INSERT INTO `system_user` VALUES (2, '13122222222', '122@qq.com', 'editor', '$2a$10$fO/0pSZM.IXlWHmn.BsiEuqlRKz4vHikROeVucYBesdIdzMcqwBhO', '修改者', 0, 1111, '2022-12-22 17:27:30', 2, '2026-05-31 14:47:44', 0, 0);
INSERT INTO `system_user` VALUES (3, '13111111111', '123213@qq.com', 'test', '$2a$10$fO/0pSZM.IXlWHmn.BsiEuqlRKz4vHikROeVucYBesdIdzMcqwBhO', '测试', 0, 0, '2024-09-06 11:33:50', 1, '2026-05-31 16:00:20', 0, 0);

-- ----------------------------
-- Table structure for system_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_user_permission`;
CREATE TABLE `system_user_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '用户id',
  `permission_id` bigint NOT NULL DEFAULT 0 COMMENT '权限id',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uerId`(`user_id` ASC) USING BTREE COMMENT '用户id',
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统_用户权限关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user_permission
-- ----------------------------

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '用户id',
  `role_id` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  `create_by` bigint NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_userId`(`user_id` ASC) USING BTREE COMMENT '用户id',
  INDEX `idx_deleted` (`deleted`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统_用户角色关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES (1, 1, 1, 0, '2023-01-06 17:19:30', 0, '2023-01-06 17:19:30', 0);
INSERT INTO `system_user_role` VALUES (2, 2, 2, 0, '2026-05-31 12:17:31', 0, '2026-05-31 12:17:31', 0);

SET FOREIGN_KEY_CHECKS = 1;