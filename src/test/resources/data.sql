INSERT INTO `role` (`id`, `created_by`, `created_date`, `enabled`, `last_modified_by`, `last_modified_date`, `code`, `label`) VALUES (1,'10000','2016-08-25 02:24:09.123456','','10000','2017-08-25 02:24:11.123456','ROLE_ADMIN','System Administrator');
INSERT INTO `user` (`id`, `created_by`, `created_date`, `enabled`, `last_modified_by`, `last_modified_date`, `account_expired`, `cellphone`, `credentials_expired`, `email`, `expired`, `first_name`, `full_name`, `guid`, `last_name`, `locked`, `nick_name`, `password`, `username`) VALUES (1,'10000','2016-08-25 02:23:53.123456','','10000','2017-08-25 02:23:57.123456',0,'15692015683',0,'admin@minlia.com',0,'admin','administrator','10000','istrator',0,'admin','$2a$10$wpizgM9q0V4j3stnP.GS/u/ZJeTfqBshPxc2v5u93IY3c9t89D0Re','admin');
INSERT INTO `map_user_roles` (`user_id`, `role_id`) VALUES (1, 1);