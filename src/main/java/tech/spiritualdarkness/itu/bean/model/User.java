package tech.spiritualdarkness.itu.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;


@Data
@TableName("itu_user")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","jwt_code","phone_code"}, allowSetters = true)
public class User implements Serializable {
    @NotNull(message = "ID不能为空")
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 2,max = 6 , message = "用户名长度必须在{min},{max}")
    private String username;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 5, max = 10, message = "密码长度必须在{min},{max}")
    private String password;
    private int phone_code;
    private int jwt_code;
}
