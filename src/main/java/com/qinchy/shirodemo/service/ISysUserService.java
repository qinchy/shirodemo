package com.qinchy.shirodemo.service;

import com.qinchy.shirodemo.model.SysUser;

public interface ISysUserService {
    /**
     * 通过username查找用户信息;
     */
    public SysUser findByUsername(String username);
}
