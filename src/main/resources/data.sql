
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

INSERT INTO `d2derp`.`questions` (`question_number`, `answer`, `option1`, `option2`, `option3`, `option4`, `questions`, `course_id`, `questions_topic_id`) VALUES ('1', 'Java', 'Java', 'C++', 'DotNet', 'Angular', 'which is best programming language?', '1', '1');
INSERT INTO `d2derp`.`questions` (`question_number`, `answer`, `option1`, `option2`, `option3`, `option4`, `questions`, `course_id`, `questions_topic_id`) VALUES ('2', 'Angular', 'Angular', 'C++', 'DotNet', 'ngular', 'which is latest programming language?', '2', '3');
INSERT INTO `d2derp`.`questions` (`question_number`, `answer`, `option1`, `option2`, `option3`, `option4`, `questions`, `course_id`, `questions_topic_id`) VALUES ('3', 'Array', 'Array', 'Boolean', 'Integer', 'String', 'how can we store fixed set of data?', '1', '2');
INSERT INTO `d2derp`.`questions` (`question_number`, `answer`, `option1`, `option2`, `option3`, `option4`, `questions`, `course_id`, `questions_topic_id`) VALUES ('4', 'Routing', 'Routing', 'Component Interaction', 'Data Binding', 'Interpolation', 'In which topic queryparams comes under?', '2', '4');

INSERT INTO `d2derp`.`question_paper` (`question_paper_id`, `name`) VALUES ('1', 'Java');
INSERT INTO `d2derp`.`question_paper` (`question_paper_id`, `name`) VALUES ('2', 'Angular');

INSERT INTO `d2derp`.`questions_topic` (`id`, `topic`, `course_id`) VALUES ('1', 'Oops', '1');
INSERT INTO `d2derp`.`questions_topic` (`id`, `topic`, `course_id`) VALUES ('2', 'MultiThreatening', '1');
INSERT INTO `d2derp`.`questions_topic` (`id`, `topic`, `course_id`) VALUES ('3', 'Component Interaction', '2');
INSERT INTO `d2derp`.`questions_topic` (`id`, `topic`, `course_id`) VALUES ('4', 'Routing', '2');

INSERT INTO `d2derp`.`batch` (`id`, `name`, `client_id`) VALUES ('1', 'nov-dec', '1');


CREATE TABLE `ques_quespaper_asso` (
  `quespaper_id` int(11) NOT NULL,
  `ques_id` int(11) NOT NULL,
  KEY `FKtda16dbj1xd3qbhu0lh5ba8p9` (`quespaper_id`),
    KEY `FK9ok3cpp8gq0x8aamkn509qatp` (`ques_id`),
    PRIMARY KEY (quespaper_id, ques_id));
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `question_paper_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdicamsd2ecsl3tfija5cwk3u2` (`batch_id`),
  KEY `FKshfnw5r7w64ty7vuqyqbd6x5` (`question_paper_id`)
) 