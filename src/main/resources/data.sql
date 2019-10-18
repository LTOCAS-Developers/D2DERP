
use d2derp;
select * from user_type;
select * from client;
select * from user;
insert into user_type values(1,"A");
insert into user_type values(2,"C");
insert into user_type values(3,"CA");
insert into user_type values(4,"T");
INSERT INTO `d2derp`.`user` (`id`, `cpass`, `created_date`, `email`, `first_name`, `ip_address`, `last_modified_date`, `last_name`, `mobile_number`, `pass`, `sno`, `status`, `client_id`, `user_type_id`) VALUES ('2', '123456', '2019-10-01 10:52:41', 'vijay1997may@gmail.com', 'Vijay', '222222', '2019-10-01 10:52:41', 'Devops', '8760083507', '123456', '1', 'ok', '1', '1');
insert into client values(1,"Ltocas");
INSERT INTO `d2derp`.`client` (`id`, `company_name`) VALUES ('2', 'Cts');
INSERT INTO `d2derp`.`course` (`id`, `name`) VALUES ('1', 'Java');
INSERT INTO `d2derp`.`course` (`id`, `name`) VALUES ('2', 'Angular');
CREATE TABLE `ques_quespaper_asso` (
  `quespaper_id` int(11) NOT NULL,
  `ques_id` int(11) NOT NULL,
  KEY `FKtda16dbj1xd3qbhu0lh5ba8p9` (`quespaper_id`),
    KEY `FK9ok3cpp8gq0x8aamkn509qatp` (`ques_id`),
    PRIMARY KEY (quespaper_id, ques_id));

