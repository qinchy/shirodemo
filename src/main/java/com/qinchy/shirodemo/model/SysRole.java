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
    private String roleName;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色<->权限关系：多对多关系;
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_Role_funcs", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "func_id")})
    private List<SysFunc> funcs;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysFunc> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<SysFunc> funcs) {
        this.funcs = funcs;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", funcs=" + funcs +
                '}';
    }
}
