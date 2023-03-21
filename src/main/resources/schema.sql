create table if not exists `user` (
    `id` int unsigned auto_increment,
    `username` varchar(50) not null unique,
    `password` varchar(500) not null,
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `role`
(
    `id` int unsigned auto_increment,
    `name`  varchar(50) not null,
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `sys_user_role` (
    `id` int unsigned auto_increment,
    `user_id` int,
    `role_id` int,
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;