package com.qinchy.shirodemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
     * 密码
     */
    private String password;

    // 立即从数据库中进行加载数据
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_User_Roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    /**
     * 一个用户具有多个角色
     */
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
