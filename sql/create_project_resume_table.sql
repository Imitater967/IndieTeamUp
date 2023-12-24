drop table if exists itu_project_resume;

create table `itu_project_resume`
(
    project_id         int not null auto_increment UNIQUE,
    publisher_uuid        int not null,
    introduce    varchar(127),
    finish_stage     ENUM('未开工','Demo','正式发行','版本更新'),
    game_type     enum('角色扮演','休闲','动作',
        '策略','模拟','益智','街机','冒险','卡牌','体育',
        '竞速','知识问答','教育','音乐'),
    qualify enum('无','个体户','小规模','一般'),
    salary_stock tinyint,
    salary tinyint,
    finance smallint,
    finish_date DATE,
    pay_method ENUM('免费','月薪','外包','均可'),
    work_method ENUM('兼职','全职','均可'),
    PRIMARY KEY (`project_id`)

) engine = InnoDB
  default charset = utf8mb4;

create table `itu_project_progress`
(
    project_id         int not null auto_increment primary key ,
    progress_type     enum('程序','美术','设计','音乐','音效'),
    next_finish_stage     ENUM('Demo','正式发行','版本更新'),
    progress_description varchar(255),
    progress float
) engine = InnoDB
  default charset = utf8mb4;