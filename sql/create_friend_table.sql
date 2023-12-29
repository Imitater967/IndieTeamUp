drop table if exists itu_job_employee_relation;

create table itu_job_employee_relation
(
    employee_uuid int not null,
    employee_agree bool,
    company_uuid int not null ,
    company_agree bool
) engine = InnoDB
  default charset = utf8mb4;