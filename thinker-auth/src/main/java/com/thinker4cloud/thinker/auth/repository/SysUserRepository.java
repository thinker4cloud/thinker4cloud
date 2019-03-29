package com.thinker4cloud.thinker.auth.repository;

import com.thinker4cloud.thinker.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    Optional<SysUser> findSysUserByUsername(String username);
}
