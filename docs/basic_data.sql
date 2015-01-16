
-- -----------------------------------------------------
-- Table `cms_core`.`user`
-- -----------------------------------------------------

TRUNCATE TABLE `cms_core`.`user`;
INSERT INTO `cms_core`.`user` (`user_id`, `email`, `mobile`,`nickname`, `password`, `salt`, `is_active`, `is_email_verified`, `is_mobile_verified`, `client_ip`, `created`, `updated`, `last_login`, `last_ip`) VALUES ('1', 'liuxiaokun0410@qq.com', '18521599183','doumiao', 'bf247c55f35bf879a0d86b69d04e1561', 'ssss', '1', '1', '1', '0', '2014-01-01 21:12:38', '2014-01-01 21:16:38', '2014-01-01 21:15:38', '0');

-- -----------------------------------------------------
-- Table `cms_core`.`category`
-- -----------------------------------------------------

TRUNCATE TABLE `cms_core`.`category`;

INSERT INTO `cms_core`.`category` (`category_id`, `parent_id`, `name`, `description`, `icon`, `is_deleted`, `created`, `updated`) VALUES ('1', '0', 'Java', 'Java related.', 'http://t11.baidu.com/it/u=3034132144,4091860566&fm=96', '0', '2014-01-01 21:15:38', '2014-01-01 21:16:38');
INSERT INTO `cms_core`.`category` (`category_id`, `parent_id`, `name`, `description`, `icon`, `is_deleted`, `created`, `updated`) VALUES ('2', '0', 'Php', 'Php relatead.', 'http://t12.baidu.com/it/u=3778279685,2362934562&fm=58', '0', '2014-01-01 21:15:38', '2014-01-01 21:16:38');

INSERT INTO `cms_core`.`category` (`category_id`, `parent_id`, `name`, `description`, `icon`, `is_deleted`, `created`, `updated`) VALUES ('3', '1', 'Spring', 'spring framework.', 'http://img4.imgtn.bdimg.com/it/u=1151346665,5348117&fm=23&gp=0.jpg', '0', '2014-01-01 21:15:38', '2014-01-01 21:16:38');
INSERT INTO `cms_core`.`category` (`category_id`, `parent_id`, `name`, `description`, `icon`, `is_deleted`, `created`, `updated`) VALUES ('4', '1', 'Hibernate', 'Hibernate framework.', 'http://img4.imgtn.bdimg.com/it/u=4145790068,960842814&fm=21&gp=0.jpg', '0', '2014-01-01 21:15:38', '2014-01-01 21:16:38');

-- -----------------------------------------------------
-- Table `cms_core`.`content`
-- -----------------------------------------------------

TRUNCATE TABLE `cms_core`.`content`;

INSERT INTO `cms_core`.`content` (`content_id`, `user_id`, `title`, `description`, `content`, `category_id`, `sort_order`, `is_deleted`, `created`, `updated`) VALUES ('1', '1', 'Spring in action', 'Good article.', 'Spring是一个开源框架，Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson 在其著作Expert One-On-One J2EE Development and Design中阐述的部分理念和原型衍生而来。它是为了解决企业应用开发的复杂性而创建的。框架的主要优势之一就是其分层架构，分层架构允许使用者选择使用哪一个组件，同时为 J2EE 应用程序开发提供集成的框架。Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。然而，Spring的用途不仅限于服务器端的开发。从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。简单来说，Spring是一个轻量级的控制反转（IoC）和面向切面（AOP）的容器框架。', '3', '1', '0', '2015-01-01 21:15:38', '2015-01-02 21:15:38');
INSERT INTO `cms_core`.`content` (`content_id`, `user_id`, `title`, `description`, `content`, `category_id`, `sort_order`, `is_deleted`, `created`, `updated`) VALUES ('2', '1', 'Hibernate in action.', 'Good article.', 'Hibernate是一个开放源代码的对象关系映射框架，它对JDBC进行了非常轻量级的对象封装，使得Java程序员可以随心所欲的使用对象编程思维来操纵数据库。 Hibernate可以应用在任何使用JDBC的场合，既可以在Java的客户端程序使用，也可以在Servlet/JSP的Web应用中使用，最具革命意义的是，Hibernate可以在应用EJB的J2EE架构中取代CMP，完成数据持久化的重任。', '3', '2', '0', '2015-01-01 21:15:38', '2015-01-03 21:15:38');

-- -----------------------------------------------------
-- Table `cms_core`.`role`
-- -----------------------------------------------------

TRUNCATE TABLE `cms_core`.`role`;

INSERT INTO `cms_core`.`role` (`role_id`, `name`, `is_active`, `created`, `updated`) VALUES ('1', 'ROLE_ADMIN', '1', '2014-01-01 21:15:38', '2014-01-01 21:16:38');
INSERT INTO `cms_core`.`role` (`role_id`, `name`, `is_active`, `created`, `updated`) VALUES ('2', 'ROLE_USER', '1', '2014-01-01 21:15:38', '2014-01-01 21:16:38');

-- -----------------------------------------------------
-- Table `cms_core`.`user_role`
-- -----------------------------------------------------

TRUNCATE TABLE `cms_core`.`user_role`;

INSERT INTO `cms_core`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `cms_core`.`user_role` (`user_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `cms_core`.`user_role` (`user_id`, `role_id`) VALUES ('2', '2');



