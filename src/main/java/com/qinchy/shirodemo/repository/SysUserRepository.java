package com.qinchy.shirodemo.repository;

import com.qinchy.shirodemo.model.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * UserInfo持久化类;
 *
 * @version v.0.1
 */
public interface SysUserRepository extends CrudRepository<SysUser, Long> {

    /**
     * 通过username查找用户信息;
     */
    public SysUser findByUsername(String username);

}