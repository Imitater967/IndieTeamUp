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

drop table if exists itu_user_contact;
create table itu_user_contact(
    uuid int,
    phone varchar(13),
    wx varchar(20),
    qq varchar(11),
    mail varchar(30),
    primary key (uuid)
)engine = InnoDB
 default charset = utf8mb4;