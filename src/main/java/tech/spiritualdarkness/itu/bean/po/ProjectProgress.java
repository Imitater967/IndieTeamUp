package tech.spiritualdarkness.itu.bean.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.ProjectProgressStatus;
import tech.spiritualdarkness.itu.bean.enumtype.ProjectProgressType;

@Data

@NoArgsConstructor
@AllArgsConstructor
@TableName("itu_project_progress")
public class ProjectProgress {
    @TableId
    Integer uuid;
    ProjectProgressType type;
    ProjectProgressStatus status;
    String description;
    //这里不需要用引用类型
    float progress;
}
