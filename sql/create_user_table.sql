create table itu_user
(
    uuid int unsigned auto_increment,
    username varchar(16) not null,
    password varchar(32),
    phone_code smallint,
    jwt_code varchar(255),
    primary key (uuid)
) engine = InnoDB
  default charset = utf8mb4;

create table itu_user_identify(
    uuid  int not null,
    id_card varchar(18),
    biz_cert varchar(18),
    wx_openid varchar(255),
    qq_openid varchar(255),
    primary key (uuid)

) engine = InnoDB  default charset = utf8mb4;