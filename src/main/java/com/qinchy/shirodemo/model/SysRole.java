package com.qinchy.shirodemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Entity
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * 编号
     */
    private Long roleId;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    @Column(unique = true)
    private String name;

    /**
     * 角色<->权限关系：多对多关系;
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_Role_funcs", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "func_id")})
    private List<SysFuncs> funcs;

    /**
     * 用户<->角色关系定义; 一个角色对应多个用户
     */
    @ManyToMany
    @JoinTable(name = "Sys_User_Role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<SysUser> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysFuncs> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<SysFuncs> funcs) {
        this.funcs = funcs;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", funcs=" + funcs +
                ", users=" + users +
                '}';
    }
}
