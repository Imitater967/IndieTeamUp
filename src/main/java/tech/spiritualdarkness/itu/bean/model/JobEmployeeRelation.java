package tech.spiritualdarkness.itu.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//单方面同意 = 关注列表 或已发送请求
//双方同意 = 好友位
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("itu_job_employee_relation")
public class JobEmployeeRelation {
    private Integer employee_uuid;
    private boolean employee_agree;
    private Integer company_uuid;
    private boolean company_agree;
}
