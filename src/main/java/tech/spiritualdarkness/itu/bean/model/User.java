package tech.spiritualdarkness.itu.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("itu_user")
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class User implements Serializable {

    private int id;

    @NotEmpty(message = "用户名不能为空")
    private String username;
    private String phone;
    private int code;
}
