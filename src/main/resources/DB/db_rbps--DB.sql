/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_rbps

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-19 01:43:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `auth_id` varchar(50) NOT NULL COMMENT '用户ID',
  `auth_type` varchar(2) NOT NULL COMMENT '用户类型(ec/客户经理/运营团队)',
  `auth_number` varchar(50) DEFAULT NULL COMMENT 'ec用户保存ec_number',
  `auth_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9003662336 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('23', '42116', 'G', '42116', '流量统付运营支撑团队', null);
INSERT INTO `auth_user` VALUES ('9003662272', '5712', 'M', '5712', '韩澍', null);
INSERT INTO `auth_user` VALUES ('9003662273', '23410', 'M', '23410', '王雅周 ', null);
INSERT INTO `auth_user` VALUES ('9003662279', '21205', 'M', '21205', ' 王玉玺', null);
INSERT INTO `auth_user` VALUES ('9003662281', '5809', 'G', '5809', 'yunwei', null);
INSERT INTO `auth_user` VALUES ('9003662298', '358720', 'E', '000210037100100000', '海南港澳资讯产业股份有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662299', '4117', 'E', '89889828002751', '京蓝汛通信技术有限责任公司', null);
INSERT INTO `auth_user` VALUES ('9003662300', '2', 'G', '2', 'yunweiceshi', null);
INSERT INTO `auth_user` VALUES ('9003662301', '164617', 'E', '250070008250250000', '中国石化管道储运有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662302', '209513', 'E', '250210319250250000', '南京市信息中心', null);
INSERT INTO `auth_user` VALUES ('9003662303', '453839', 'E', '200321094200200000', '深圳市无限融合科技有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662304', '443174', 'E', '351220257351351000', '上海月呈信息技术有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662305', '509978', 'E', '250211599250250000', '智汇神州信息发展有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662306', '12100', 'E', '5715717118216', '杭州市西湖区人民政府', null);
INSERT INTO `auth_user` VALUES ('9003662307', '515332', 'E', '230210507230230000', '成都太字节科技有限责任公司', null);
INSERT INTO `auth_user` VALUES ('9003662308', '492310', 'E', '951210073951951000', '武汉筹谋企业管理有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662309', '459580', 'E', '591699999591000426', '咪咕动漫有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662310', '537703', 'E', '471690970100100000', '内蒙古鑫乌金肥料有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662311', '1030', 'M', '1030', '方晓', null);
INSERT INTO `auth_user` VALUES ('9003662312', '26492', 'M', '26492', '韦桂芳', null);
INSERT INTO `auth_user` VALUES ('9003662313', '101', 'M', '101', 'BIZ200', null);
INSERT INTO `auth_user` VALUES ('9003662314', '578972', 'E', '771011788771771000', '广西壮族自治区国有高峰林场平厂分场', null);
INSERT INTO `auth_user` VALUES ('9003662315', '2', 'M', '2', '省BOSS系统', null);
INSERT INTO `auth_user` VALUES ('9003662316', '1', 'M', '1', '系统管理员', null);
INSERT INTO `auth_user` VALUES ('9003662317', '412475', 'E', '200330232200200000', '北京信达优创通信技术有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662318', '5813', 'E', '7717205000403', '上汽通用五菱汽车股份有限公司', null);
INSERT INTO `auth_user` VALUES ('9003662319', '5810', 'G', '5810', '赵纪飞', null);
INSERT INTO `auth_user` VALUES ('9003662320', '398276', 'E', '250230677250250000', '苏酒集团贸易股份有限公司（苏酒集团）', null);
INSERT INTO `auth_user` VALUES ('9003662322', '21502', 'M', '21502', '冯健峰', '2016-12-22 11:30:40');
INSERT INTO `auth_user` VALUES ('9003662323', '445339', 'E', '871005118871871000', '卓望信息网络（深圳）有限公司', '2017-03-17 19:55:04');
INSERT INTO `auth_user` VALUES ('9003662324', '460032', 'E', '200220195200200000', '卓望信息网络（深圳）有限公司', '2017-03-17 20:02:20');
INSERT INTO `auth_user` VALUES ('9003662325', '3', 'Z', '3', '运营中心资管组', '2017-03-20 10:17:20');
INSERT INTO `auth_user` VALUES ('9003662326', '4', 'J', '4', '省接口人', null);
INSERT INTO `auth_user` VALUES ('9003662327', '5', 'J', '5', '地市接口人', null);
INSERT INTO `auth_user` VALUES ('9003662328', '101', 'Z', '101', 'BIZ200', '2017-03-22 13:42:37');
INSERT INTO `auth_user` VALUES ('9003662329', '101', 'J', '101', 'BIZ200', '2017-03-22 14:09:40');
INSERT INTO `auth_user` VALUES ('9003662330', '5252', 'J', '5252', '耿雪红', '2017-03-22 14:51:16');
INSERT INTO `auth_user` VALUES ('9003662333', '27233', 'G', '27233', '张歆', '2017-04-10 14:38:35');
INSERT INTO `auth_user` VALUES ('9003662335', 'aaaaa', '', 'aaa', 'aaaa', '2017-04-16 23:23:25');

-- ----------------------------
-- Table structure for ec_sys_message
-- ----------------------------
DROP TABLE IF EXISTS `ec_sys_message`;
CREATE TABLE `ec_sys_message` (
  `message_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT 'userId',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `source` int(1) DEFAULT NULL COMMENT '来源(1系统消息2预警消息3下载消息)',
  `source_id` varchar(50) DEFAULT NULL COMMENT '来源id(下载为download_id预警为warning_message_id)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `read_status` int(1) DEFAULT NULL COMMENT '读取状态',
  `read_time` datetime DEFAULT NULL COMMENT '读取时间',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_sys_message
-- ----------------------------
INSERT INTO `ec_sys_message` VALUES ('17', '1', '您下载的新专线2.0订单运营分析报表_201606-201607已完成，请到下载列表下载文件', '3', '32', '2017-03-15 04:32:53', '0', null);
INSERT INTO `ec_sys_message` VALUES ('18', '1', '您下载的新专线2.0订单运营分析报表_201606-201607已完成，请到下载列表下载文件', '3', '35', '2017-03-15 04:59:07', '0', null);
INSERT INTO `ec_sys_message` VALUES ('19', '1', '您下载的新专线2.0订单运营分析报表_201606-201607已完成，请到下载列表下载文件', '3', '36', '2017-03-15 05:17:35', '0', null);
INSERT INTO `ec_sys_message` VALUES ('20', '1', '您下载的新专线2.0订单运营分析报表_201606-201607已完成，请到下载列表下载文件', '3', '38', '2017-03-15 05:56:51', '0', null);
INSERT INTO `ec_sys_message` VALUES ('21', '1', '您下载的新专线2.0订单运营分析报表_201606-201607已完成，请到下载列表下载文件', '3', '39', '2017-03-15 06:11:07', '0', null);
INSERT INTO `ec_sys_message` VALUES ('22', '1', '您下载的新专线2.0审批不通过订单报表_201606-201607已完成，请到下载列表下载文件', '3', '40', '2017-03-15 06:11:51', '0', null);
INSERT INTO `ec_sys_message` VALUES ('23', '1', '您下载的新专线2.0审批不通过订单报表_201612-201701已完成，请到下载列表下载文件', '3', '41', '2017-03-16 00:34:34', '0', null);
INSERT INTO `ec_sys_message` VALUES ('24', '1', '您下载的新专线2.0审批不通过订单报表_201701-201702已完成，请到下载列表下载文件', '3', '42', '2017-03-16 00:35:04', '0', null);
INSERT INTO `ec_sys_message` VALUES ('25', '1', '您下载的新专线2.0审批不通过订单报表_201701-201702已完成，请到下载列表下载文件', '3', '43', '2017-03-16 00:35:41', '0', null);
INSERT INTO `ec_sys_message` VALUES ('26', '1', '您下载的新专线2.0审批不通过订单报表_201701-201702已完成，请到下载列表下载文件', '3', '44', '2017-03-16 00:36:05', '0', null);
INSERT INTO `ec_sys_message` VALUES ('27', '1', '您下载的新专线2.0审批不通过订单报表_201701-201702已完成，请到下载列表下载文件', '3', '45', '2017-03-16 00:38:07', '0', null);
INSERT INTO `ec_sys_message` VALUES ('28', '1', '您下载的新专线2.0订单运营分析报表_201701-201702已完成，请到下载列表下载文件', '3', '46', '2017-03-16 01:17:26', '0', null);
INSERT INTO `ec_sys_message` VALUES ('29', '9003662323', '未读消息', '1', null, '2017-03-17 01:17:26', '0', null);
INSERT INTO `ec_sys_message` VALUES ('30', '1', '您下载的新专线2.0审批不通过订单报表_201603-201608已完成，请到下载列表下载文件', '3', '47', '2017-03-19 07:41:11', '0', null);
INSERT INTO `ec_sys_message` VALUES ('31', '1', '您下载的新专线2.0审批不通过订单报表_201603-201608已完成，请到下载列表下载文件', '3', '48', '2017-03-19 07:41:18', '0', null);
INSERT INTO `ec_sys_message` VALUES ('32', '9003662325', '您下载的新专线2.0订单运营分析报表_201701-201702已完成，请到下载列表下载文件', '3', '49', '2017-03-19 23:28:12', '0', null);
INSERT INTO `ec_sys_message` VALUES ('33', '1', '您下载的新专线2.0订单运营分析报表_201701-201702已完成，请到下载列表下载文件', '3', '50', '2017-03-20 00:14:49', '0', null);
INSERT INTO `ec_sys_message` VALUES ('63', '9003662304', '温馨提示:您订购的通用流量统付产品在04月06日使用量已超过1017个', '2', '2', '2017-04-07 14:56:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('64', '9003662304', '温馨提示:截止04月06日,您订购的通用流量统付产品月使用量已超过81760个', '2', '3', '2017-04-07 14:56:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('65', '9003662300', '温馨提示:您关注的流量包在04月06日单订购日使用量已超过31个的已有26个订购', '2', '4', '2017-04-07 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('66', '9003662319', '温馨提示:您关注的流量包在04月06日单订购日使用量已超过31个的已有26个订购', '2', '5,6', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('67', '9003662300', '温馨提示:截止04月06日,您关注的流量包业务单订购月使用量已超过32个的已有60个订购', '2', '7', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('68', '9003662319', '温馨提示:截止04月06日,您关注的流量包业务单订购月使用量已超过32个的已有60个订购', '2', '8,9', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('69', '9003662300', '温馨提示:您关注的流量包业务总量在04月06日已超过198617个', '2', '10', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('70', '9003662319', '温馨提示:您关注的流量包业务总量在04月06日已超过198617个', '2', '11,12', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('71', '9003662300', '温馨提示:截止04月06日,您关注的流量包月业务总量已超过9769594个', '2', '13', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('72', '9003662319', '温馨提示:截止04月06日,您关注的流量包月业务总量已超过9769594个', '2', '14,15', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('73', '9003662300', '温馨提示:截止04月06日,您关注的流量包月业务量环比增幅超过36%的已有20个订购', '2', '16', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('74', '9003662319', '温馨提示:截止04月06日,您关注的流量包月业务量环比增幅超过36%的已有20个订购', '2', '17,18', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('75', '9003662300', '温馨提示:截止04月06日,您关注的流量包分省月业务量环比增幅超过38%的已有1个省', '2', '19', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('76', '9003662319', '温馨提示:截止04月06日,您关注的流量包分省月业务量环比增幅超过38%的已有1个省', '2', '20,21', '2017-03-08 15:50:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('77', '9003662300', '温馨提示:截止04月06日,您关注的流量包业务单用户月使用量超过100个的已有8人', '2', '22', '2017-04-07 17:14:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('78', '9003662319', '温馨提示:截止04月06日,您关注的流量包业务单用户月使用量超过100个的已有8人', '2', '23,24', '2017-04-07 17:14:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('79', '9003662300', '温馨提示:您关注的流量包业务在04月06日单用户日使用量超过29个的已有1人', '2', '25', '2017-04-07 17:14:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('80', '9003662319', '温馨提示:您关注的流量包业务在04月06日单用户日使用量超过29个的已有1人', '2', '26,27', '2017-04-07 17:14:00', '0', null);
INSERT INTO `ec_sys_message` VALUES ('81', '9003662300', '温馨提示:截止04月06日,您关注的流量包业务单用户月使用量超过100个的已有1人', '2', '28', '2017-04-07 20:26:24', '0', null);
INSERT INTO `ec_sys_message` VALUES ('82', '9003662319', '温馨提示:截止04月06日,您关注的流量包业务单用户月使用量超过100个的已有1人', '2', '29,30', '2017-04-07 20:26:24', '0', null);
INSERT INTO `ec_sys_message` VALUES ('83', '9003662300', '温馨提示:您关注的流量包业务在04月06日单用户日使用量超过29个的已有1人', '2', '31', '2017-04-07 20:26:24', '0', null);
INSERT INTO `ec_sys_message` VALUES ('84', '9003662319', '温馨提示:您关注的流量包业务在04月06日单用户日使用量超过29个的已有1人', '2', '32,33', '2017-04-07 20:26:24', '0', null);

-- ----------------------------
-- Table structure for product_model
-- ----------------------------
DROP TABLE IF EXISTS `product_model`;
CREATE TABLE `product_model` (
  `model_id` bigint(11) NOT NULL,
  `model_name` varchar(50) DEFAULT NULL,
  `model_type` int(3) DEFAULT NULL,
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_model
-- ----------------------------
INSERT INTO `product_model` VALUES ('1', '不限用户,全量统付', '200');
INSERT INTO `product_model` VALUES ('2', '不限用户,限量统付', '200');
INSERT INTO `product_model` VALUES ('3', '指定用户,全量统付', '200');
INSERT INTO `product_model` VALUES ('4', '指定用户,定额统付', '100');
INSERT INTO `product_model` VALUES ('5', '指定用户,限量统付', '200');

-- ----------------------------
-- Table structure for sys_client_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_client_info`;
CREATE TABLE `sys_client_info` (
  `client_info_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) NOT NULL COMMENT '客户端ID',
  `client_code` varchar(50) NOT NULL COMMENT '客户端code',
  `description` varchar(100) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`client_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_client_info
-- ----------------------------
INSERT INTO `sys_client_info` VALUES ('1', '100', 'Dgn8fXQ756tTo90sObZxNzskzuzP4K1yOQmxRrnnfzY=', '测试clientCode');
INSERT INTO `sys_client_info` VALUES ('2', '101', 'JzUdKtvzdEcyWNwyuQhIG8KT1Rwvf1qNBEe9dtQT0FY=', '运营团队账号');
INSERT INTO `sys_client_info` VALUES ('3', '201', 'AwrK8lQ3v9rCVungNz9pAt7oz7U44bjurWONsn7n8OI=', '客户经理账号');
INSERT INTO `sys_client_info` VALUES ('4', '301', '3XVnjySWu/04AqKU8O6bzeeucMlxOWMSOzsePYq/bAQ=', 'EC账号');
INSERT INTO `sys_client_info` VALUES ('5', '202', 'wMikHOKbeVd0dtghrhwC2b858KGaKPj5waQd+M8lWug=', '客户经理两级');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(50) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `menu_addr` varchar(100) NOT NULL,
  `parent_menu_id` bigint(11) DEFAULT NULL,
  `res_id` bigint(11) DEFAULT NULL,
  `pop_menu_name` varchar(100) DEFAULT NULL,
  `menu_description` varchar(100) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '资源目录', '#', '-1', '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '100', '首页', 'index.htm', '1', '2', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('3', '200', '业务统计', 'data/statistics/index.htm', '1', '3', '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('4', '300', '业务明细', 'data/businessDetail/index.htm', '1', '40', '业务明细', null, 'open');
INSERT INTO `sys_menu` VALUES ('5', '400', '我的订购', '', '1', null, '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('6', '201', '流量日统计', 'data/flowpool/daySummary.htm', '3', '4', '按日统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('7', '202', '流量月统计', 'data/flowpool/monthSummary.htm', '3', '5', '按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('8', '500', '运营统计', 'data/statistics/index.htm', '1', '6', '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('9', '300', '详单查询', 'data/businessDetail/index.htm', '1', '7', '详单查询', null, 'open');
INSERT INTO `sys_menu` VALUES ('10', '203', '分省日统计', 'data/flowpool/dayProvSummary.htm', '3', '8', '分省日统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('11', '204', '分省月统计', 'data/flowpool/monthProvSummary.htm', '3', '9', '分省月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('12', '205', '超高用户日统计', 'data/flowpool/dayExceedCust.htm', '3', '10', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('13', '206', '超高用户月统计', 'data/flowpool/monthExceedCust.htm', '3', '11', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('14', '207', '月使用量阶梯分布', 'data/flowpool/monthLadderCust.htm', '3', '12', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('15', '208', '业务环比日统计', '#', '3', null, '', null, 'open');
INSERT INTO `sys_menu` VALUES ('16', '209', '总量日统计', 'data/gprspackage/daySummary.htm', '3', '14', '按日统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('17', '210', '总量月统计', 'data/gprspackage/monthSummary.htm', '3', '15', '按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('18', '211', '分省日统计', 'data/gprspackage/dayProvSummary.htm', '3', '16', '分省日统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('19', '212', '分省月统计', 'data/gprspackage/monthProvSummary.htm', '3', '17', '分省月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('20', '213', '超高用户日统计', 'data/gprspackage/dayExceedCust.htm', '3', '18', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('21', '214', '超高用户月统计', 'data/gprspackage/monthExceedCust.htm', '3', '19', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('22', '215', '业务环比日统计', '#', '3', null, '', null, 'open');
INSERT INTO `sys_menu` VALUES ('23', '216', '订购', '#', '8', '21', '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('24', '217', '流量包', '#', '8', '22', '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('25', '218', '流量池', '#', '8', '23', '', null, 'closed');
INSERT INTO `sys_menu` VALUES ('26', '219', '按月统计', 'subscription/data/monthSummary.htm', '23', '24', '按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('27', '220', '分省统计', 'subscription/data/monthProvSummary.htm', '23', '25', '分省月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('28', '223', '总量日统计', 'data/gprspackage/daySummary.htm', '24', '26', '按天统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('29', '224', '总量月统计', 'data/gprspackage/monthSummary.htm', '24', '27', '按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('30', '225', '分省日统计', 'data/gprspackage/dayProvSummary.htm', '24', '28', '分省日统计\r\n', null, 'open');
INSERT INTO `sys_menu` VALUES ('31', '226', '分省月统计', 'data/gprspackage/monthProvSummary.htm', '24', '29', '分省月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('32', '227', '超高用户日统计', 'data/gprspackage/dayExceedCust.htm', '24', '30', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('33', '228', '超高用户月统计', 'data/gprspackage/monthExceedCust.htm', '24', '31', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('34', '229', '流量日统计', 'data/flowpool/daySummary.htm', '25', '32', '按天统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('35', '230', '流量月统计', 'data/flowpool/monthSummary.htm', '25', '33', '按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('36', '231', '分省日统计', 'data/flowpool/dayProvSummary.htm', '25', '34', '分省日统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('37', '232', '分省月统计', 'data/flowpool/monthProvSummary.htm', '25', '35', '分省月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('38', '233', '超高用户日统计', 'data/flowpool/dayExceedCust.htm', '25', '36', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('39', '234', '超高用户月统计', 'data/flowpool/monthExceedCust.htm', '25', '37', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('40', '235', '月使用量阶梯分布', 'data/flowpool/monthLadderCust.htm', '25', '38', '', null, 'open');
INSERT INTO `sys_menu` VALUES ('41', '236', '业务环比日统计', '#', '25', null, '', null, 'open');
INSERT INTO `sys_menu` VALUES ('42', '237', '套餐档位日统计', 'data/gprspackage/dayGearSummary.htm', '3', '40', '套餐档位按天统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('43', '238', '套餐档位月统计', 'data/gprspackage/monthGearSummary.htm', '3', '41', '套餐档位按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('44', '239', '套餐档位日统计', 'data/gprspackage/dayGearSummary.htm', '24', '40', '套餐档位按天统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('45', '240', '套餐档位月统计', 'data/gprspackage/monthGearSummary.htm', '24', '41', '套餐档位按月统计', null, 'open');
INSERT INTO `sys_menu` VALUES ('46', '600', '新专线2.0运营分析订单', 'dedicatedLine/new/zxOrder.htm', '1', '42', null, null, 'open');
INSERT INTO `sys_menu` VALUES ('47', '700', '审批不通过订单', 'dedicatedLine/new/noPassOrder.htm', '1', '43', null, null, 'open');

-- ----------------------------
-- Table structure for sys_prod_model_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_prod_model_menu`;
CREATE TABLE `sys_prod_model_menu` (
  `model_type` int(3) DEFAULT NULL COMMENT '产品类型',
  `menu_id` bigint(11) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_prod_model_menu
-- ----------------------------
INSERT INTO `sys_prod_model_menu` VALUES ('200', '5');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '6');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '9');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '10');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '11');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '12');
INSERT INTO `sys_prod_model_menu` VALUES ('200', '13');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '15');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '16');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '17');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '18');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '19');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '20');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '41');
INSERT INTO `sys_prod_model_menu` VALUES ('100', '42');

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
  `authId` int(11) NOT NULL AUTO_INCREMENT,
  `authName` varchar(20) DEFAULT NULL,
  `authPath` varchar(100) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `authDescription` varchar(200) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `iconCls` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES ('1', '管理系统', '#', '-1', '', 'closed', 'icon-home');
INSERT INTO `t_auth` VALUES ('2', '系统管理', ' ', '1', '', 'closed', 'icon-permission');
INSERT INTO `t_auth` VALUES ('3', '系统用户管理', 'static/html/managerManager.html', '2', '', 'open', 'icon-userManage');
INSERT INTO `t_auth` VALUES ('4', '系统角色管理', 'static/html/sysRoleManager.html', '2', '', 'open', 'icon-roleManage');
INSERT INTO `t_auth` VALUES ('5', '系统菜单管理', 'static/html/menuManager.html', '2', '', 'open', 'icon-menuManage');
INSERT INTO `t_auth` VALUES ('7', '权限管理', ' ', '1', '', 'closed', 'icon-auth');
INSERT INTO `t_auth` VALUES ('15', '修改密码', '', '1', null, 'open', 'icon-modifyPassword');
INSERT INTO `t_auth` VALUES ('16', '安全退出', '', '1', null, 'open', 'icon-exit');
INSERT INTO `t_auth` VALUES ('34', '用户管理', 'static/html/userManager.html', '7', '', 'open', 'icon-user');
INSERT INTO `t_auth` VALUES ('36', '角色管理', 'static/html/ecRoleManager.html', '7', '', 'open', 'icon-role');
INSERT INTO `t_auth` VALUES ('38', '资源管理', 'static/html/resourceManager.html', '7', '', 'open', 'icon-auth');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `managerType` int(4) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `managerDescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`managerId`),
  KEY `FK_t_user` (`roleId`),
  CONSTRAINT `FK_t_user` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', 'admin', 'aJkOJbxsiuEhbLazN5jNfQ==', '1', '1', null);
INSERT INTO `t_manager` VALUES ('2', 'test', 'sh4/p6BTvuO9r/2QSWH/8Q==', '2', '2', null);
INSERT INTO `t_manager` VALUES ('36', '123', 'sh4/p6BTvuO9r/2QSWH/8Q==', '2', '3', 'ec');

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `res_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '资源主键',
  `res_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `res_type` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `res_code` varchar(50) DEFAULT NULL COMMENT '权限代码',
  `parent_id` bigint(11) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '资源目录', null, 'RES_RIGHT', null, '-1', 'closed');
INSERT INTO `t_resource` VALUES ('2', '首页', null, 'MENU_RIGHT', null, '1', null);
INSERT INTO `t_resource` VALUES ('3', '业务统计', null, 'MENU_RIGHT', null, '1', 'closed');
INSERT INTO `t_resource` VALUES ('4', '按月汇总', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('5', '按日汇总', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('6', '运营统计', null, 'MENU_RIGHT', null, '1', 'closed');
INSERT INTO `t_resource` VALUES ('7', '详单查询', null, 'MENU_RIGHT', null, '1', null);
INSERT INTO `t_resource` VALUES ('8', '分省月统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('9', '月超高用户数据', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('10', '月使用量阶梯用户数分布', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('11', '分省日统计', '', 'MENU_RIGHT', '', '3', null);
INSERT INTO `t_resource` VALUES ('12', '超高用户日统计', '', 'MENU_RIGHT', '', '3', null);
INSERT INTO `t_resource` VALUES ('13', '业务环比日统计', '', 'MENU_RIGHT', '', '3', null);
INSERT INTO `t_resource` VALUES ('14', '总量日统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('15', '总量月统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('16', '分省日统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('17', '分省月统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('18', '超高用户日统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('19', '超高用户月统计', null, 'MENU_RIGHT', null, '3', null);
INSERT INTO `t_resource` VALUES ('20', '业务环比日统计', null, 'MENU_RIGHT', null, null, null);
INSERT INTO `t_resource` VALUES ('21', '订购', '', 'MENU_RIGHT', '', '6', 'closed');
INSERT INTO `t_resource` VALUES ('22', '流量包', '', 'MENU_RIGHT', '', '6', 'closed');
INSERT INTO `t_resource` VALUES ('23', '流量池', '', 'MENU_RIGHT', '', '6', 'closed');
INSERT INTO `t_resource` VALUES ('24', '按月统计', '', 'MENU_RIGHT', '', '21', null);
INSERT INTO `t_resource` VALUES ('25', '分省统计', '', 'MENU_RIGHT', '', '21', null);
INSERT INTO `t_resource` VALUES ('26', '总量日统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('27', '总量月统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('28', '分省日统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('29', '分省月统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('30', '超高用户日统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('31', '超高用户月统计', '', 'MENU_RIGHT', '', '22', null);
INSERT INTO `t_resource` VALUES ('32', '流量日统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('33', '流量月统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('34', '分省日统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('35', '分省月统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('36', '超高用户日统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('37', '超高用户月统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('38', '月使用量阶梯用户数分布统计', '', 'MENU_RIGHT', '', '23', null);
INSERT INTO `t_resource` VALUES ('39', '业务环比日统计', '', 'MENU_RIGHT', '', null, null);
INSERT INTO `t_resource` VALUES ('40', '套餐档位日统计', '', 'MENU_RIGHT', null, '22', null);
INSERT INTO `t_resource` VALUES ('41', '套餐档位月统计', '', 'MENU_RIGHT', null, '22', null);
INSERT INTO `t_resource` VALUES ('42', '新专线运营分析订单', null, 'MENU_RIGHT', null, '1', null);
INSERT INTO `t_resource` VALUES ('43', '审批不通过订单', null, 'MENU_RIGHT', null, '1', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  `authIds` varchar(50) DEFAULT NULL,
  `roleType` varchar(50) DEFAULT NULL,
  `roleDescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '1,2,3,4,5,6,7,34,15,16', 'MM', '具有最高权限');
INSERT INTO `t_role` VALUES ('2', '资源管理员', '1,2,6,15,16', null, '拥有资源管理的权限');
INSERT INTO `t_role` VALUES ('3', '运营集团', '1,2,6,15,16', 'G', '运营团队');
INSERT INTO `t_role` VALUES ('4', '客户经理', '1,2,6,15,16', 'M', '客户经理');
INSERT INTO `t_role` VALUES ('5', 'EC客户', '1,2,6,15,16', 'E', 'ec');
INSERT INTO `t_role` VALUES ('6', '运营中心资管组', '1,2,6,15,16', 'Z', '资管组');
INSERT INTO `t_role` VALUES ('7', '接口人', '1,2,6,15,16', 'J', '接口人');
INSERT INTO `t_role` VALUES ('8', '111111', null, '1', '1111');

-- ----------------------------
-- Table structure for t_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_role_auth`;
CREATE TABLE `t_role_auth` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `auth_id` bigint(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_auth
-- ----------------------------
INSERT INTO `t_role_auth` VALUES ('1', '1', '1');
INSERT INTO `t_role_auth` VALUES ('2', '1', '2');
INSERT INTO `t_role_auth` VALUES ('3', '1', '3');
INSERT INTO `t_role_auth` VALUES ('4', '1', '4');
INSERT INTO `t_role_auth` VALUES ('5', '1', '5');
INSERT INTO `t_role_auth` VALUES ('7', '1', '7');
INSERT INTO `t_role_auth` VALUES ('8', '1', '15');
INSERT INTO `t_role_auth` VALUES ('9', '1', '16');
INSERT INTO `t_role_auth` VALUES ('10', '1', '34');
INSERT INTO `t_role_auth` VALUES ('11', '1', '36');
INSERT INTO `t_role_auth` VALUES ('12', '1', '38');

-- ----------------------------
-- Table structure for t_role_res
-- ----------------------------
DROP TABLE IF EXISTS `t_role_res`;
CREATE TABLE `t_role_res` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `res_id` bigint(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_res
-- ----------------------------
INSERT INTO `t_role_res` VALUES ('1', '3', '2');
INSERT INTO `t_role_res` VALUES ('2', '3', '6');
INSERT INTO `t_role_res` VALUES ('3', '3', '7');
INSERT INTO `t_role_res` VALUES ('4', '5', '2');
INSERT INTO `t_role_res` VALUES ('5', '5', '3');
INSERT INTO `t_role_res` VALUES ('6', '5', '4');
INSERT INTO `t_role_res` VALUES ('7', '5', '5');
INSERT INTO `t_role_res` VALUES ('8', '5', '8');
INSERT INTO `t_role_res` VALUES ('9', '5', '9');
INSERT INTO `t_role_res` VALUES ('10', '5', '10');
INSERT INTO `t_role_res` VALUES ('11', '4', '2');
INSERT INTO `t_role_res` VALUES ('12', '5', '11');
INSERT INTO `t_role_res` VALUES ('13', '5', '12');
INSERT INTO `t_role_res` VALUES ('14', '5', '14');
INSERT INTO `t_role_res` VALUES ('15', '5', '15');
INSERT INTO `t_role_res` VALUES ('16', '5', '16');
INSERT INTO `t_role_res` VALUES ('17', '5', '17');
INSERT INTO `t_role_res` VALUES ('18', '5', '18');
INSERT INTO `t_role_res` VALUES ('19', '5', '19');
INSERT INTO `t_role_res` VALUES ('20', '5', '20');
INSERT INTO `t_role_res` VALUES ('21', '3', '21');
INSERT INTO `t_role_res` VALUES ('22', '3', '22');
INSERT INTO `t_role_res` VALUES ('23', '3', '23');
INSERT INTO `t_role_res` VALUES ('24', '3', '24');
INSERT INTO `t_role_res` VALUES ('25', '3', '25');
INSERT INTO `t_role_res` VALUES ('26', '3', '26');
INSERT INTO `t_role_res` VALUES ('27', '3', '27');
INSERT INTO `t_role_res` VALUES ('28', '3', '28');
INSERT INTO `t_role_res` VALUES ('29', '3', '28');
INSERT INTO `t_role_res` VALUES ('30', '3', '29');
INSERT INTO `t_role_res` VALUES ('31', '3', '30');
INSERT INTO `t_role_res` VALUES ('32', '3', '32');
INSERT INTO `t_role_res` VALUES ('33', '3', '31');
INSERT INTO `t_role_res` VALUES ('34', '3', '32');
INSERT INTO `t_role_res` VALUES ('35', '3', '33');
INSERT INTO `t_role_res` VALUES ('36', '3', '34');
INSERT INTO `t_role_res` VALUES ('37', '3', '35');
INSERT INTO `t_role_res` VALUES ('38', '3', '36');
INSERT INTO `t_role_res` VALUES ('39', '3', '37');
INSERT INTO `t_role_res` VALUES ('40', '3', '38');
INSERT INTO `t_role_res` VALUES ('41', '5', '39');
INSERT INTO `t_role_res` VALUES ('42', '4', '3');
INSERT INTO `t_role_res` VALUES ('43', '4', '4');
INSERT INTO `t_role_res` VALUES ('44', '4', '5');
INSERT INTO `t_role_res` VALUES ('45', '4', '8');
INSERT INTO `t_role_res` VALUES ('46', '4', '9');
INSERT INTO `t_role_res` VALUES ('47', '4', '10');
INSERT INTO `t_role_res` VALUES ('48', '4', '11');
INSERT INTO `t_role_res` VALUES ('49', '4', '12');
INSERT INTO `t_role_res` VALUES ('50', '4', '13');
INSERT INTO `t_role_res` VALUES ('51', '4', '14');
INSERT INTO `t_role_res` VALUES ('52', '4', '15');
INSERT INTO `t_role_res` VALUES ('53', '4', '16');
INSERT INTO `t_role_res` VALUES ('54', '4', '17');
INSERT INTO `t_role_res` VALUES ('55', '4', '18');
INSERT INTO `t_role_res` VALUES ('56', '4', '19');
INSERT INTO `t_role_res` VALUES ('57', '4', '20');
INSERT INTO `t_role_res` VALUES ('58', '4', '39');
INSERT INTO `t_role_res` VALUES ('59', '5', '40');
INSERT INTO `t_role_res` VALUES ('60', '5', '41');
INSERT INTO `t_role_res` VALUES ('61', '3', '40');
INSERT INTO `t_role_res` VALUES ('62', '3', '41');
INSERT INTO `t_role_res` VALUES ('63', '4', '40');
INSERT INTO `t_role_res` VALUES ('64', '4', '41');
INSERT INTO `t_role_res` VALUES ('65', '6', '42');
INSERT INTO `t_role_res` VALUES ('66', '7', '43');
INSERT INTO `t_role_res` VALUES ('67', '3', '1');
INSERT INTO `t_role_res` VALUES ('68', '4', '1');
INSERT INTO `t_role_res` VALUES ('69', '5', '1');
INSERT INTO `t_role_res` VALUES ('70', '6', '1');
INSERT INTO `t_role_res` VALUES ('71', '7', '1');
INSERT INTO `t_role_res` VALUES ('77', '3', '46');
INSERT INTO `t_role_res` VALUES ('78', '3', '47');
INSERT INTO `t_role_res` VALUES ('80', '7', '41');
INSERT INTO `t_role_res` VALUES ('81', '7', '42');
INSERT INTO `t_role_res` VALUES ('82', '7', '40');
INSERT INTO `t_role_res` VALUES ('94', '8', '1');
INSERT INTO `t_role_res` VALUES ('95', '8', '6');
INSERT INTO `t_role_res` VALUES ('96', '8', '23');
INSERT INTO `t_role_res` VALUES ('97', '8', '34');
INSERT INTO `t_role_res` VALUES ('98', '8', '35');
INSERT INTO `t_role_res` VALUES ('99', '8', '36');
INSERT INTO `t_role_res` VALUES ('100', '8', '37');
INSERT INTO `t_role_res` VALUES ('101', '8', '38');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '23', '3');
INSERT INTO `t_user_role` VALUES ('2', '9003662272', '4');
INSERT INTO `t_user_role` VALUES ('3', '9003662273', '4');
INSERT INTO `t_user_role` VALUES ('4', '9003662279', '4');
INSERT INTO `t_user_role` VALUES ('5', '9003662281', '3');
INSERT INTO `t_user_role` VALUES ('6', '9003662298', '5');
INSERT INTO `t_user_role` VALUES ('7', '9003662299', '5');
INSERT INTO `t_user_role` VALUES ('8', '9003662300', '3');
INSERT INTO `t_user_role` VALUES ('9', '9003662301', '5');
INSERT INTO `t_user_role` VALUES ('10', '9003662302', '5');
INSERT INTO `t_user_role` VALUES ('11', '9003662303', '5');
INSERT INTO `t_user_role` VALUES ('12', '9003662304', '5');
INSERT INTO `t_user_role` VALUES ('13', '9003662305', '5');
INSERT INTO `t_user_role` VALUES ('14', '9003662306', '5');
INSERT INTO `t_user_role` VALUES ('15', '9003662307', '5');
INSERT INTO `t_user_role` VALUES ('16', '9003662308', '5');
INSERT INTO `t_user_role` VALUES ('17', '9003662309', '5');
INSERT INTO `t_user_role` VALUES ('18', '9003662310', '5');
INSERT INTO `t_user_role` VALUES ('19', '9003662311', '4');
INSERT INTO `t_user_role` VALUES ('20', '9003662312', '4');
INSERT INTO `t_user_role` VALUES ('21', '9003662313', '4');
INSERT INTO `t_user_role` VALUES ('22', '9003662314', '5');
INSERT INTO `t_user_role` VALUES ('23', '9003662315', '4');
INSERT INTO `t_user_role` VALUES ('24', '9003662316', '4');
INSERT INTO `t_user_role` VALUES ('25', '9003662317', '5');
INSERT INTO `t_user_role` VALUES ('26', '9003662318', '5');
INSERT INTO `t_user_role` VALUES ('27', '9003662319', '3');
INSERT INTO `t_user_role` VALUES ('28', '9003662320', '5');
INSERT INTO `t_user_role` VALUES ('29', '9003662322', '4');
INSERT INTO `t_user_role` VALUES ('30', '9003662323', '5');
INSERT INTO `t_user_role` VALUES ('31', '9003662324', '5');
INSERT INTO `t_user_role` VALUES ('32', '9003662325', '6');
INSERT INTO `t_user_role` VALUES ('33', '9003662326', '7');
INSERT INTO `t_user_role` VALUES ('34', '9003662327', '7');
INSERT INTO `t_user_role` VALUES ('35', '9003662328', '6');
INSERT INTO `t_user_role` VALUES ('36', '9003662329', '7');
INSERT INTO `t_user_role` VALUES ('37', '9003662330', '7');
INSERT INTO `t_user_role` VALUES ('38', '9003662333', '3');
INSERT INTO `t_user_role` VALUES ('39', '1232', '1231');
INSERT INTO `t_user_role` VALUES ('46', '9003662335', '6');
INSERT INTO `t_user_role` VALUES ('47', '9003662335', '7');
