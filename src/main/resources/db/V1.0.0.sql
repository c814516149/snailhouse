create table if not exists `sh_posts` (
    `id` bigint(10) not null auto_increment comment '主键',
    `post_author_id` bigint(10) not null default 0 comment '对应作者id',
    `post_date` datetime not null comment '发布时间',
    `post_date_gmt` datetime not null comment '发布时间（GMT+o时间）',
    `post_content` text comment '文章内容',
    `post_title` varchar(100) not null default '' comment '标题',
    `post_excerpt` varchar(500) not null default '' comment '摘录',
    `post_status` tinyint(4) not null default 1 comment '文章状态 1.公开 2.私人',
    `comment_status` tinyint(4) not null default 1 comment '评论状态 1.开放 2.关闭',
    `post_password` varchar(30) default '' comment '文章密码',
    `post_name` varchar(30) not null default '' comment '文章缩略名',
    `ping_status` tinyint(4) not null default 1 comment '是否允许转载 1.允许 2不允许',
    `post_modified` datetime comment '修改时间',
    `post_modified_gmt` datetime comment '修改时间（GMT+o时间）',
    `post_parent` bigint(10) default 0 comment '父文章，用于page',
    `menu_order` int(10) default 0 comment '排序id',
    `post_type` tinyint(4) not null default 1 comment '文章类型 1.原创 2.转载',
    `post_mime_type` varchar(20) comment 'mime类型',
    `comment_count` int(10) not null default 0 comment '评论总数',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '文章表';

create table if not exists `sh_postmeta`(
    `meta_id` bigint(10) not null auto_increment comment '元数据主键',
    `post_id` bigint(10) not null comment '对应文章id',
    `meta_key` varchar(20) not null default '' comment '键名',
    `meta_value` varchar(100) not null default '' comment '键值',
    primary key(`meta_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '文章元数据表';

create table if not exists `sh_terms`(
    `term_id` int(10) not null auto_increment comment '分类id',
    `name` varchar(20) not null default '' comment '分类名',
    `slug` varchar(20) not null default '' comment '缩略名',
    primary key(`term_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '文章分类表';

create table if not exists `sh_term_relationships`(
    `object_id` bigint(10) not null comment '文章id',
    `term_taxonomy_id` bigint(10) not null comment '分类方法id',
    `term_order` int(10) not null comment '排序id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '文章分类关系表';

create table if not exists `sh_term_taxonomy`(
    `term_taxonomy_id` int(10) not null auto_increment comment '分类方法id',
    `term_id` int(10) not null  comment '分类id',
    `taxonomy` varchar(20) not null default 'tag' comment '分类方法（tag,category)',
    `parent` int(10) not null default 0 comment '父分类id',
    `count` int(10) not null default 0 comment '文章数',
    primary key(`term_taxonomy_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '文章分类方法表';

CREATE TABLE if not exists `sh_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` varchar(32) DEFAULT NULL COMMENT '版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'sql版本表';

INSERT INTO `sh_version` VALUES ('1', '1.0.0', NOW());