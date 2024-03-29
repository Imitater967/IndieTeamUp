drop table  if exists itu_user_person_resume;
create table itu_user_person_resume
(
    uuid       int not null UNIQUE ,
    real_name varchar(6),
    age tinyint,
    work_type ENUM('线上','线下','线下或线下') not null,
    sex ENUM('男','女'),
    pay_method ENUM('免费','月薪','外包','均可'),
    work_method ENUM('兼职','全职','均可'),
    min_qualify ENUM('无','个体户','小规模','一般'),
    current_province VARCHAR(128),
    expect_province VARCHAR(128),
    job varchar(16),
    salary_stock tinyint,
    salary tinyint,
    introduce varchar(255),
    update_date Date,
    primary key (`uuid`)
) engine = InnoDB
  default charset = utf8mb4;

drop table if exists itu_user_person_education;
create table itu_user_person_education
(
    uuid         int not null primary key ,
    degree    enum('大专','本科','硕士及以上') not null ,
    university varchar(16) not null ,
    graduate DATE not null
) engine = InnoDB
  default charset = utf8mb4;


# drop table if exists itu_user_person_skill_overview;
# create table itu_user_person_skill_overview
# (
#     uuid        int not null ,
#     skill_name varchar(16) not null ,
#     skill_level tinyint not null
# ) engine = InnoDB
#   default charset = utf8mb4;


drop table if exists `itu_user_person_skill`;
create table `itu_user_person_skill`
(
    uuid         int not null,
    skill_name varchar(16) not null ,
    skill_level tinyint not null ,
    start_time DATE not null ,
    end_time DATE not null ,
    company varchar(50) not null ,
    project varchar(16) not null ,
    url   varchar(255) not null
) engine = InnoDB
  default charset = utf8mb4;