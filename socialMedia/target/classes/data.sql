--initital startup sample data

insert into user(id, name) values (10001, 'Mayank');
insert into user(id, name) values (10002, 'Rajeev');
insert into user(id, name) values (10003, 'Rohan');
insert into user(id, name) values (10004, 'Abhay');
insert into user(id, name) values (10005, 'Anand');
insert into user(id, name) values (10006, 'Amit');
insert into user(id, name) values (10007, 'Akshay');
insert into user(id, name) values (10008, 'Vijay');
insert into user(id, name) values (10009, 'Rahul');
insert into user(id, name) values (10010, 'John');
insert into user(id, name) values (10011, 'Allen');
----------
insert into USER_FOLLOWEE(user_id, followee_Id) values (10001, 10003);
insert into USER_FOLLOWEE(user_id, followee_Id) values (10001, 10002);
insert into USER_FOLLOWEE(user_id, followee_Id) values (10001, 10008);
insert into USER_FOLLOWEE(user_id, followee_Id) values (10004, 10007);
insert into USER_FOLLOWEE(user_id, followee_Id) values (10004, 10002);
insert into USER_FOLLOWEE(user_id, followee_Id) values (10011, 10001);
----------
insert into post(post_id, content, create_time, posted_by) values (800001, 'Some content by 10001', '2020-01-15 03:23:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800002, 'Some content by 10001', '2020-01-15 05:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800003, 'Some content by 10001', '2024-01-13 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800004, 'Some content by 10001', '2019-01-14 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800005, 'Some content by 10001', '2019-01-03 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800006, 'Some content by 10001', '2019-01-22 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800007, 'Some content by 10001', '2019-01-21 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800008, 'Some content by 10001', '2019-01-13 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800009, 'Some content by 10001', '2019-01-11 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800010, 'Some content by 10001', '2020-03-16 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800011, 'Some content by 10001', '2019-08-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800012, 'Some content by 10001', '2019-03-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800013, 'Some content by 10001', '2019-11-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800014, 'Some content by 10001', '2020-11-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800015, 'Some content by 10001', '2022-01-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800016, 'Some content by 10001', '2021-01-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800017, 'Some content by 10001', '2019-01-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800018, 'Some content by 10001', '2020-01-07 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800019, 'Some content by 10001', '2020-05-10 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800020, 'Some content by 10001', '2020-01-25 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800021, 'Some content by 10001', '2020-01-22 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800022, 'Some content by 10001', '2020-01-20 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800023, 'Some content by 10001', '2020-01-19 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800024, 'Some content by 10001', '2020-01-18 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800025, 'Some content by 10001', '2020-02-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800026, 'Some content by 10001', '2020-04-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800027, 'Some content by 10001', '2020-08-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800028, 'Some content by 10001', '2020-06-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800029, 'Some content by 10001', '2020-01-15 08:20:00.0', 10001);
insert into post(post_id, content, create_time, posted_by) values (800030, 'Some content by 10011', '2021-07-15 08:20:00.0', 10011);
insert into post(post_id, content, create_time, posted_by) values (800031, 'Some content by 10011', '2021-05-15 08:20:00.0', 10011);
insert into post(post_id, content, create_time, posted_by) values (800032, 'Some content by 10011', '2020-01-14 06:20:00.0', 10011);