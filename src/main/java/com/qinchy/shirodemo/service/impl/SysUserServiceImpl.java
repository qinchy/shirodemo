package com.qinchy.shirodemo.service.impl;

import com.qinchy.shirodemo.model.SysUser;
import com.qinchy.shirodemo.repository.SysUserRepository;
import com.qinchy.shirodemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
