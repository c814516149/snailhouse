alter table sh_posts add column `visit_count` int(10) not null default '0' comment '访问次数';
INSERT INTO `sh_version`(version, create_time) VALUES ('1.0.1', NOW());