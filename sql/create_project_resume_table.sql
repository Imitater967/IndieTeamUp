drop table if exists itu_project_resume;

create table `itu_project_resume`
(
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
    update_date Date,
    PRIMARY KEY (`publisher_uuid`)

) engine = InnoDB
  default charset = utf8mb4;

drop table if exists `itu_project_progress`;
create table `itu_project_progress`
(
    uuid         int not null,
    type        enum('总进度','设计','精灵资产','模型资产','贴图资产','材质资产',
        '动画资产','音效资产','UI资产','程序资产'),
    status      enum('未计算','筹备中','工作中','动态'),
    description varchar(255),
    progress float default 0
) engine = InnoDB
  default charset = utf8mb4;