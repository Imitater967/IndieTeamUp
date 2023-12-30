package tech.spiritualdarkness.itu.bean.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("itu_user_contact")
@AllArgsConstructor
@NoArgsConstructor
public class UserContact {
    @TableId
    private Integer uuid;
    private String phone;
    private String wx;
    private String qq;
    private String mail;
}
