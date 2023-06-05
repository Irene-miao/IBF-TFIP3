drop database if exists feeds;

create database feeds;

use feeds;

create table posts(
post_id char(8) not null,
image mediumblob not null,
image_type varchar(32) not null,

primary key(post_id)
);

grant all privileges on feeds.* to 'fred'@'localhost';

