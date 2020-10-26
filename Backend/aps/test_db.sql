SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_team`
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team` (
  `teamid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` text,
  `num` int(11) NOT NULL,
  `begin_day` int(11) NOT NULL,
  `end_day` int(11) NOT NULL,
  `begin_time` int(11) NOT NULL,
  `end_time` int(11) NOT NULL,
  PRIMARY KEY (`teamid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_team
-- ----------------------------
INSERT INTO t_team VALUES ('1', '小刚', '5', '1', '5', '9', '22');
INSERT INTO t_team VALUES ('2', '小红', '4', '1', '5', '7', '20');
INSERT INTO t_team VALUES ('3', '小明', '3', '1', '5', '19', '7');
-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `material_code` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `delivery_date` date,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO t_order VALUES ('1', '1', '500', '2020-10-25');
INSERT INTO t_order VALUES ('2', '2', '400', '2020-10-26');
-- ----------------------------
-- Table structure for `t_equipment`
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment`;
CREATE TABLE `t_equipment` (
  `equipmentid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` text,
  `type` text,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`equipmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_equipment
-- ----------------------------
INSERT INTO t_equipment VALUES ('1', 'lineA', 'line', '1');
INSERT INTO t_equipment VALUES ('2', 'lineB', 'line', '1');
-- ----------------------------
-- Table structure for `t_craft`
-- ----------------------------
DROP TABLE IF EXISTS `t_craft`;
CREATE TABLE `t_craft` (
  `craftid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `material_code` int(11) NOT NULL,
  `human_num` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`craftid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_craft
-- ----------------------------
INSERT INTO t_craft VALUES ('1', '1', '5', '50');
INSERT INTO t_craft VALUES ('2', '2', '7', '100');