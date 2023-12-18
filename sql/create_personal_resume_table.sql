create table `itu_user_person_resume`
(
    `uuid`         int not null primary key ,
    `work_type` ENUM('线上','线下','线下或线下') not null,
    `sex` ENUM('男','女'),
    'pay_method' ENUM('免费','月薪','外包','均可'),
    'work_method' ENUM('兼职','全职','均可'),
    'min_qualify' ENUM('无','个体户','小规模','一般'),
    'current_province' smallint,
    'expect_province' smallint,
    'first_job' varchar(8),
    'second_job' varchar(8),
    'salary_stock' tinyint,
    'salary' tinyint,
    'introduce' varchar(255),
    primary key (`uuid`)
) engine = InnoDB
  default charset = utf8mb4;

create table `itu_user_person_education`
(
    `uuid`         int not null primary key ,
    'degree'    enum('大专','本科','硕士及以上') not null ,
    'university' varchar(16) not null ,
    'graduate' DATETIME not null ,
    primary key (`uuid`)
) engine = InnoDB
  default charset = utf8mb4;


create table `itu_user_person_skill_overview`
(
    `uuid`         int not null primary key ,
    'skill_name' varchar(16) not null ,
    'skill_level' tinyint not null ,
    primary key (`uuid`)
) engine = InnoDB
  default charset = utf8mb4;


create table `itu_user_person_skill_detail`
(
    `uuid`         int not null primary key ,
    'skill_name' varchar(16) not null primary key ,
    'skill_level' tinyint not null ,
    'start_time' DATETIME not null ,
    'end_time' DATETIME not null ,
    'company' varchar(50) not null ,
    'project' varchar(16) not null ,
    'url'   varchar(255) not null ,
    primary key (`uuid`)
) engine = InnoDB
  default charset = utf8mb4;