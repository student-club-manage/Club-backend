package com.feng.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ExcelProperty(index = 0)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ExcelProperty(index = 1)
    private String name;
    /**
     * 性别（0保密，1男，2女）
     */
    @ExcelProperty(index = 2)
   private Integer sex;
    /**
     * 学院
     */
    @ExcelProperty(index = 3)
    private String institute;
    @NotNull(message = "用户账号不能为空")
    @Email(message = "请输入合法邮箱")
    @ExcelProperty(index = 4)
    private String account;
    //    @JsonIgnore
    @ExcelProperty(index = 5)
    @NotNull(message = "用户密码不能为空")
    @Length(min=6,max=16,message = "密码至少6位，最多16位")
    private String password;
    @ExcelProperty(index = 6)
    @TableField("role_id")
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户创建时间
     */
    @ExcelProperty(index = 7)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
    @DateTimeFormat(pattern = "yyyy年MM月dd")
    private Date createTime;
    /**
     * 用户是否激活（默认0，未激活；1激活）
     */
    @ExcelProperty(index = 8)
    private Boolean isActive;
    @ExcelProperty(index = 9)
    private String lastLoginTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", institute=" + institute +
        ", account=" + account +
        ", password=" + password +
        ", role=" + roleId +
        ", createTime=" + createTime +
        ", isActive=" + isActive +
        ", lastLoginTime=" + lastLoginTime +
        "}";
    }
}
