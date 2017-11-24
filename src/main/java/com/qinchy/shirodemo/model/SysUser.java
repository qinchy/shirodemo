package com.qinchy.shirodemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Entity
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * 用户id
     */
    private Long userId;

    @Column(unique = true)
    /**
     * 账号
     */
    private String username;

    /**
     * 姓名或者昵称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密密码用的盐
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte state;

    /**
     * 一个用户具有多个角色
     * 立即从数据库中进行加载数据
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_User_Roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<SysRole> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roles=" + roles +
                '}';
    }
}
