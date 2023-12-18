create table `itu_project_resume`
(
    `uuid`         int not null primary key ,
    `project_id`         int not null primary key ,
    'introduce'     varchar(127),
    'game_type'     enum('角色扮演','休闲','动作',
        '策略','模拟','益智','街机','冒险','卡牌','体育',
        '竞速','知识问答','教育','音乐'),
    'qualify' enum('无','个体户','小规模','一般'),

) engine = InnoDB
  default charset = utf8mb4;
